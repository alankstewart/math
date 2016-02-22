package alankstewart.math.lineart

import java.awt.geom.{Line2D, Point2D}

import scala.math.{Pi, cos, sin}
import scala.swing._

/**
  * Created by alanstewart on 22/02/2016.
  */
object OneThousandLines extends App with Lines {

  val Size = 1024

  val size = if (args.length > 0 && args(0).matches("-?\\d+")) args(0).toInt else Size
  display(size)

  override def getLineComponent(d: Dimension) = {
    new OneThousandLinesComponent(d)
  }

  class OneThousandLinesComponent(d: Dimension) extends LineComponent(d) {

    val Lines = 1000

    override def getLines = {
      Lines
    }

    override def getLineSegment(n: Int) = {
      new Line2D.Double(getPoint1(n), getPoint2(n));
    }

    private def getPoint1(n: Int) = {
      new Point2D.Double(sin(4 * Pi * n / Lines) * tx, cos(2 * Pi * n / Lines) * tx)
    }

    private def getPoint2(n: Int) = {
      new Point2D.Double(0.5 * sin(8 * Pi * n / Lines) * tx, 0.5 * cos(4 * Pi * n / Lines) * tx)
    }
  }

}
