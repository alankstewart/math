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
import static java.util.stream.Collectors.toList;

/**
 * Created by alankstewart on 23/12/14.
 */
public class TwoThousandLines {

    private static final int SIZE = 768;
    private static final int SCALE = SIZE * 15 / 32;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame jf = new JFrame("2000 Lines");
            jf.setSize(SIZE, SIZE);
            jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            jf.add(new LineComponent());
            jf.setVisible(true);
        });
    }

    static class LineComponent extends JComponent {

        private static final int LINES = 2000;

        @Override
        public void paintComponent(Graphics g) {
            Graphics2D g2d = (Graphics2D) g;
            g2d.setColor(Color.DARK_GRAY);
            g2d.translate(SIZE / 2, SIZE / 2);
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            IntStream.rangeClosed(1, LINES).mapToObj(this::getLine).collect(toList()).forEach(g2d::draw);
        }

        private Line2D.Double getLine(int n) {
            return new Line2D.Double(getPoint(12, 10, n), getPoint(8, 6, n));
        }

        private Point2D.Double getPoint(int l, int m, int n) {
            return new Point2D.Double(pow(sin(l * PI * n / LINES), 3) * SCALE, pow(cos(m * PI * n / LINES), 3) * SCALE);
        }
    }
}