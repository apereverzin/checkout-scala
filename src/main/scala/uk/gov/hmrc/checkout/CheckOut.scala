package uk.gov.hmrc.checkout

import uk.gov.hmrc.checkout.ShoppingCart._

object CheckOut {
  def main(args: Array[String]) {
    println(getTotalPrice(ShoppingCart(args)))
  }
}