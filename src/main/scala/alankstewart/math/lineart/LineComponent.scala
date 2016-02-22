package alankstewart.math.lineart

import java.awt._
import java.awt.geom.Line2D
import javax.swing.JComponent

import scala.swing.Graphics2D

/**
  * Created by alanstewart on 22/02/2016.
  */
abstract class LineComponent(d: Dimension) extends JComponent {

  val tx = d.getWidth / 2.0
  val ty = d.getHeight / 2.0

  override def paintComponent(g: Graphics) = {
    val g2d = g match {
      case g2d: Graphics2D => g2d
      case _ => throw new ClassCastException
    }
    g2d.setColor(Color.DARK_GRAY)
    g2d.translate(tx, ty)
    g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON)
    Range.inclusive(1, getLines).map(getLineSegment).foreach(s => g2d.draw(s))
  }

  def getLines: Int

  def getLineSegment(n: Int): Line2D.Double
}
