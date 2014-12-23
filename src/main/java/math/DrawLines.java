package alankstewart.math;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;
import java.util.stream.IntStream;

import static java.lang.Math.PI;
import static java.lang.Math.cos;
import static java.lang.Math.pow;
import static java.lang.Math.sin;
import static java.util.stream.Collectors.toList;

/**
 * Created by alanstewart on 23/12/14.
 */
public class DrawLines {

    private static final int LINES = 2000;
    private static final int SIZE = 768;
    private static final int SCALE = SIZE * 15 / 32;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame jf = new JFrame("2000 Lines");
            jf.setSize(SIZE, SIZE);
            jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            jf.add(new LineComponent());
            jf.setVisible(true);
        });
    }

    static class LineComponent extends JComponent {

        @Override
        public void paintComponent(Graphics g) {
            Graphics2D g2d = (Graphics2D) g;
            g2d.setColor(Color.DARK_GRAY);
            g2d.translate(SIZE / 2, SIZE / 2);
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            IntStream.rangeClosed(1, LINES).mapToObj(n -> new Line2D.Double(
                    pow(sin(12 * PI * n / LINES), 3) * SCALE, pow(cos(10 * PI * n / LINES), 3) * SCALE,
                    pow(sin(8 * PI * n / LINES), 3) * SCALE, pow(cos(6 * PI * n / LINES), 3) * SCALE))
                    .collect(toList())
                    .forEach(g2d::draw);
        }
    }
}