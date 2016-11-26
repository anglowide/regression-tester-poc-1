/**
  * Created by curtisa on 07/11/16.
  */
case class TradeReport(
  fund: String,
  tradeId: String,
  mv: Double
)

object TradeReport {
  def fund(s: String): String = s
  def tradeId(s: String): String = s
  def mv(d: Double): Double = d
}
