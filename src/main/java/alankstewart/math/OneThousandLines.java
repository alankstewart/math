package alankstewart.math;

import java.awt.*;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;

import static java.lang.Math.PI;
import static java.lang.Math.cos;
import static java.lang.Math.sin;

/**
 * Created by alankstewart on 23/01/15.
 */
public final class OneThousandLines extends AbstractLines {

    public static void main(final String[] args) {
        final int size = args.length > 0 && args[0] != null && args[0].matches("-?\\d+") ? Integer.parseInt(args[0]) : SIZE;
        final OneThousandLines oneThousandLines = new OneThousandLines();
        oneThousandLines.display(size);
    }

    @Override
    protected AbstractLineComponent getLineComponent(final Dimension d) {
        return new LineComponent(d);
    }

    static class LineComponent extends AbstractLineComponent {

        private static final int LINES = 1000;

        public LineComponent(final Dimension d) {
            super(d);
        }

        @Override
        protected int getLines() {
            return LINES;
        }

        @Override
        protected Line2D.Double getLineSegment(final int n) {
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