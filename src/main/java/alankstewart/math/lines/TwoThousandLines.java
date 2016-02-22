package alankstewart.math.lines;

import java.awt.*;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;

import static java.lang.Math.PI;
import static java.lang.Math.cos;
import static java.lang.Math.pow;
import static java.lang.Math.sin;

/**
 * Created by alankstewart on 23/12/14.
 */
public final class TwoThousandLines implements Lines {

    private static final int SIZE = 1024;

    public static void main(final String[] args) {
        final int size = args.length > 0 && args[0] != null && args[0].matches("-?\\d+") ? Integer.parseInt(args[0]) : SIZE;
        final TwoThousandLines twoThousandLines = new TwoThousandLines();
        twoThousandLines.display(size);
    }

    @Override
    public LineComponent getLineComponent(final Dimension d) {
        return new TwoThousandLinesComponent(d);
    }

    static class TwoThousandLinesComponent extends LineComponent {

        private static final int LINES = 2000;

        public TwoThousandLinesComponent(final Dimension d) {
            super(d);
        }

        @Override
        protected int getLines() {
            return LINES;
        }

        @Override
        protected Line2D.Double getLineSegment(final int n) {
            return new Line2D.Double(getPoint(12, 10, n), getPoint(8, 6, n));
        }

        private Point2D.Double getPoint(final int l, final int m, final int n) {
            return new Point2D.Double(pow(sin(l * PI * n / LINES), 3) * tx, pow(cos(m * PI * n / LINES), 3) * tx);
        }
    }
}