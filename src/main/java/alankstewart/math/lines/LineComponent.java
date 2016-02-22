package alankstewart.math.lines;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;
import java.util.stream.IntStream;

/**
 * Created by alanstewart on 23/01/15.
 */
abstract class LineComponent extends JComponent {

    protected final double tx;
    protected final double ty;

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
        IntStream.rangeClosed(1, getLines()).mapToObj(this::getLineSegment).forEach(g2d::draw);
    }

    protected abstract int getLines();

    protected abstract Line2D.Double getLineSegment(final int n);
}
