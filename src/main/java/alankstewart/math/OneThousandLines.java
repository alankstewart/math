package alankstewart.math;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.util.stream.IntStream;

import static java.lang.Math.PI;
import static java.lang.Math.cos;
import static java.lang.Math.pow;
import static java.lang.Math.sin;

/**
 * Created by alankstewart on 23/12/14.
 */
public class OneThousandLines {

    private static final int SIZE = 1024;

    public static void main(final String[] args) {
        final int size = args.length > 0 && args[0] != null && args[0].matches("-?\\d+") ? Integer.parseInt(args[0]) : SIZE;
        final Dimension d = new Dimension(size, size);
        SwingUtilities.invokeLater(() -> {
            final JFrame jf = new JFrame("Line Art");
            jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            jf.getContentPane().setPreferredSize(d);
            jf.pack();
            jf.add(new LineComponent(d));
            jf.setVisible(true);
        });
    }

    static class LineComponent extends JComponent {

        private static final int LINES = 1000;

        private final double tx;
        private final double ty;

        public LineComponent(final Dimension d) {
            tx = d.getWidth() / 2.0;
            ty = d.getHeight() / 2.0;
        }

        @Override
        public void paintComponent(final Graphics g) {
            final Graphics2D g2d = (Graphics2D) g;
            g2d.setColor(Color.DARK_GRAY);
            g2d.translate(tx, ty);
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            IntStream.rangeClosed(1, LINES).mapToObj(this::getLineSegment).forEach(g2d::draw);
        }

        private Line2D.Double getLineSegment(final int n) {
            return new Line2D.Double(getPoint1(n), getPoint2(n));
        }

        private Point2D.Double getPoint1(final int n) {
            return new Point2D.Double(sin(4 * PI * n / LINES) * tx, cos(2 * PI * n / LINES) * tx);
        }
        private Point2D.Double getPoint2(final int n) {
            return new Point2D.Double(0.5 * sin(8 * PI * n / LINES) * tx, 0.5 * cos(4 * PI * n / LINES) * tx);
        }
    }
}