package uk.gov.hmrc.checkout

case class ShoppingCart(items: Seq[String])

object ShoppingCart {
  val Apple = "Apple"
  val Orange = "Orange"

  val prices = Map(Apple -> 60, Orange -> 25)

  def getTotalPrice(shoppingCart: ShoppingCart): Double = {
    val counts = shoppingCart.items.groupBy(identity).mapValues(_.size)
    counts.keys.map(key => prices.get(key).get * applyOffers(key, counts.get(key).get)).sum / 100.0
  }

  def applyOffers(item: String, quantity: Int) = {
    item match {
      case "Apple" => quantity / 2 + quantity % 2
      case "Orange" => quantity / 3 * 2 + quantity % 3
    }
  }
}
