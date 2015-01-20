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
public class TwoThousandLines {

    private static final int SIZE = 768;

    public static void main(String[] args) {
        int size = args.length > 0 && args[0] != null && args[0].matches("-?\\d+") ? Integer.parseInt(args[0]) : SIZE;
        Dimension d = new Dimension(size, size);
        SwingUtilities.invokeLater(() -> {
            JFrame jf = new JFrame("Line Art");
            jf.setSize(d);
            jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            jf.add(new LineComponent(d));
            jf.setVisible(true);
        });
    }

    static class LineComponent extends JComponent {

        private static final int LINES = 2000;

        private Dimension d;
        private double scale;

        public LineComponent(Dimension d) {
            this.d = d;
        }

        @Override
        public void paintComponent(Graphics g) {
            Graphics2D g2d = (Graphics2D) g;
            g2d.setColor(Color.DARK_GRAY);
            g2d.translate(d.getWidth() / 2, d.getHeight() / 2);
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            scale = d.getWidth() * 15 / 32;
            IntStream.rangeClosed(1, LINES).mapToObj(this::getLine).forEach(g2d::draw);
        }

        private Line2D.Double getLine(int n) {
            return new Line2D.Double(getPoint(12, 10, n), getPoint(8, 6, n));
        }

        private Point2D.Double getPoint(int l, int m, int n) {
            return new Point2D.Double(pow(sin(l * PI * n / LINES), 3) * scale, pow(cos(m * PI * n / LINES), 3) * scale);
        }
    }
}