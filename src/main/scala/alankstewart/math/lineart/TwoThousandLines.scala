package alankstewart.math.lineart

import java.awt.geom.{Line2D, Point2D}

import scala.math.{Pi, cos, pow, sin}
import scala.swing._

/**
  * Created by alanstewart on 22/02/2016.
  */
object TwoThousandLines extends App with Lines {

  val Size = 1024

  val size = if (args.length > 0 && args(0).matches("-?\\d+")) args(0).toInt else Size
  display(size)

  override def getLineComponent(d: Dimension) = {
    new TwoThousandLinesComponent(d)
  }

  class TwoThousandLinesComponent(d: Dimension) extends LineComponent(d) {

    val Lines = 2000

    override def getLines = {
      Lines
    }

    override def getLineSegment(n: Int) = {
      new Line2D.Double(getPoint(12, 10, n), getPoint(8, 6, n))
    }

    private def getPoint(l: Int, m: Int, n: Int) = {
      new Point2D.Double(pow(sin(l * Pi * n / Lines), 3) * tx, pow(cos(m * Pi * n / Lines), 3) * tx)
    }
  }

}
