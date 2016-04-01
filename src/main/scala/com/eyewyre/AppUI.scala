package com.eyewyre


import _root_.java.io.File

import com.vaadin.annotations.{PreserveOnRefresh, Theme}
import com.vaadin.server.{Sizeable, VaadinRequest, VaadinService}
import com.vaadin.ui._
import com.vaadin.ui.Button.{ClickEvent, ClickListener}
import com.ning.http.client.AsyncHttpClientConfig
import com.vaadin.addon.charts.Chart
import com.vaadin.addon.charts.model.style.SolidColor
import com.vaadin.addon.charts.model.{ChartType, DataSeries, DataSeriesItem}
import play.api.libs.ws.{WS, WSResponse}
import play.api.libs.ws.ning.NingWSClient

import scala.concurrent.duration.Duration
import scala.concurrent.{Await, Future}
import scala.concurrent.ExecutionContext.Implicits.global


@Theme("apptheme")
@PreserveOnRefresh
class AppUI extends UI {

  def init(request: VaadinRequest) {

   val timeout = 60000 * 10
  //  val builder = new AsyncHttpClientConfig.Builder()
  //  val client = new NingWSClient(
  //    builder.setConnectTimeout(timeout)
  //      .setReadTimeout(timeout)
  //      .build()
  //  )


    val box = new Label("") {
      setStyleName("box")
    }

    setContent(new VerticalLayout {

      addComponent(new HorizontalLayout {
        addComponent(box)

        addComponent(new Button("Add") {
          addClickListener(new ClickListener {
            override def buttonClick(clickEvent: ClickEvent): Unit = {
              Notification.show("Adding 'grow'")
              box.addStyleName("grow")
            }
          })
        })

        addComponent(new Button("Remove") {
          addClickListener(new ClickListener {
            override def buttonClick(clickEvent: ClickEvent): Unit = {
              Notification.show("Removing 'grow'")
              box.removeStyleName("grow")
            }
          })
        })
      })

      //    client.url("http://localhost/api/authenticate/userpass")
      //      .withFollowRedirects(follow = true)
      //      .withHeaders("Content-Type" -> "application/json")
      //      .post(s"""{ "username": "", "password": "" }""")
      //      .map { response =>
      //  Notification.show(response.body)
      //    }


      // val basePath = VaadinService.getCurrent.getBaseDirectory.getAbsolutePath
      // val sampleFile = new File(basePath + "/Simple Invoice.xlsx")

      //            addComponent(new Spreadsheet(sampleFile) {
      //              setHeight(450, Sizeable.Unit.PIXELS)
      //            })

      addComponent(new Chart(ChartType.PIE) {
        setWidth(500, Sizeable.Unit.PIXELS)
        setHeight(500, Sizeable.Unit.PIXELS)

        val conf = getConfiguration
        conf.setTitle("Sample Pie")
        conf.getChart.setBackgroundColor(new SolidColor(255, 255, 255, 0))
        conf.setSeries(new DataSeries() {
          1 to 5 foreach { idx => add(new DataSeriesItem(s"Slice $idx", idx * 100)) }
        })

        drawChart(conf)
      })
    })
  }
}
