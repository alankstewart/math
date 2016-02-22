package alankstewart.math.lineart

import javax.swing.{JFrame, SwingUtilities, WindowConstants}

import scala.swing._

/**
  * Created by alanstewart on 22/02/2016.
  */
trait Lines {

  def getLineComponent(d: Dimension): LineComponent

  def display(size: Int) = {
    val d = new Dimension(size, size)
    SwingUtilities.invokeLater(new Runnable {
      override def run() = {
        val jf = new JFrame("Line Art")
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE)
        jf.getContentPane().setPreferredSize(d)
        jf.pack()
        jf.add(getLineComponent(d))
        jf.setVisible(true)
      }
    })
  }
}
