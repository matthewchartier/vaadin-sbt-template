
import org.specs2.matcher.MustThrownExpectations
import org.specs2.mutable._
import com.ning.http.client.AsyncHttpClientConfig
import play.api.libs.json._
import play.api.libs.ws.{WS, WSResponse}
import play.api.libs.ws.ning.NingWSClient
//import scala.concurrent.ExecutionContext.Implicits.global
import org.specs2.concurrent.ExecutionEnv

import scala.concurrent.duration.Duration
import scala.concurrent.{Await, Future}

case class LoginResponse(token: Option[String])


class TestSpec extends Specification {
  implicit val loginResponseFormat = Json.format[LoginResponse]

  def failed = 0 mustEqual 1

  val timeout = 60000 * 10
    val builder = new AsyncHttpClientConfig.Builder()
    val client = new NingWSClient(
      builder.setConnectTimeout(timeout)
        .setReadTimeout(timeout)
        .build()
    )


  "The REST API" should {
    "Logging in with valid credentials" should {
      val fut = client.url("http://localhost/api/authenticate/userpass")
        .withFollowRedirects(follow = true)
        .withHeaders("Content-Type" -> "application/json")
        .post( s"""{ "username": "", "password": "" }""")

      val response = Await.result(fut, Duration.Inf)
      client.close()

      "return OK on call" in {
        response.status must be equalTo (200)
      }
      "have content-type of application/json" in {
        response.header("Content-type").getOrElse("") must be contain("application/json")
      }
      "contain auth token in response" in {
        Json.parse(response.body).asOpt[LoginResponse].fold(failed) { loginResp =>
          loginResp.token must beSome
        }
      }

    }
  }

//  client.close()
}
