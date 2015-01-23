package alankstewart.math;

import javax.swing.*;
import java.awt.*;

/**
 * Created by alankstewart on 23/01/15.
 */
public abstract class AbstractLines {

    protected static final int SIZE = 1024;

    protected void display(final int size) {
        final Dimension d = new Dimension(size, size);
        SwingUtilities.invokeLater(() -> {
            final JFrame jf = new JFrame("Line Art");
            jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            jf.getContentPane().setPreferredSize(d);
            jf.pack();
            jf.add(getLineComponent(d));
            jf.setVisible(true);
        });
    }

    protected abstract AbstractLineComponent getLineComponent(final Dimension d);
}