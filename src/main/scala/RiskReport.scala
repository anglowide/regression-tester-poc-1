/**
  * Created by curtisa on 06/11/16.
  */
case class RiskReport(
  fund: String,
  position: String,
  nominal: Double,
  value: Double,
  riskCalc: Double
)

object RiskReport{
  def fund(f: String): String = f
  def position(p: String): String = p
  def nominal(n: Double): Double = n
  def value(v: Double): Double = v
  def riskCalc(rc: Double): Double = rc
}