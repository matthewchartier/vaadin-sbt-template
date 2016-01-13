
import org.specs2.mutable._


class TestSpec extends Specification {
  val ar = List(1, 2, 3, 4, 5)

  "The list container" should {
    "have 5 items" in {
      ar must have size(5)
    }
  }

}







//import collection.mutable.Stack
//import org.scalatest._

//class ExampleSpec extends FlatSpec with Matchers {
//
//  "A Stack" should "pop values in last-in-first-out order" in {
//    val stack = new Stack[Int]
//    stack.push(1)
//    stack.push(2)
//    stack.pop() should be (2)
//    stack.pop() should be (1)
//  }
//
//  it should "have two items in it when two are pushed" in {
//    val stack = new Stack[Int]
//    stack.push(1)
////    stack.push(2)
//
//    stack.size should be (2)
//  }
//
//  it should "throw NoSuchElementException if an empty stack is popped" in {
//    val emptyStack = new Stack[Int]
//    a [NoSuchElementException] should be thrownBy {
//      emptyStack.pop()
//    }
//  }
//
//
//}