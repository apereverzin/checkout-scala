package uk.gov.hmrc.checkout

import org.scalatest.{FlatSpec, Matchers}
import ShoppingCart._

class ShoppingCartTest extends FlatSpec with Matchers {

  "Checkout" should "calculate total price of an empty shopping cart" in {
    testTotalPrice(0.0, Seq())
  }

  "Checkout" should "calculate total price of a shopping cart with 1 apple" in {
    testTotalPrice(0.6, Seq(Apple))
  }

  "Checkout" should "calculate total price of a shopping cart with 4 apples" in {
    testTotalPrice(2.4, Seq(Apple, Apple, Apple, Apple))
  }

  "Checkout" should "calculate total price of a shopping cart with 1 orange" in {
    testTotalPrice(0.25, Seq(Orange))
  }

  "Checkout" should "calculate total price of a shopping cart with 4 oranges" in {
    testTotalPrice(1.0, Seq(Orange, Orange, Orange, Orange))
  }

  "Checkout" should "calculate total price of a shopping cart with 3 apples and 1 orange" in {
    testTotalPrice(2.05, Seq(Apple, Apple, Orange, Apple))
  }

  def testTotalPrice(expectedTotalPrice: Double, items: Seq[String]) = {
    val shoppingCart = ShoppingCart(items)

    val price: Double = ShoppingCart.getTotalPrice(shoppingCart)

    price should be(expectedTotalPrice)
  }
}
