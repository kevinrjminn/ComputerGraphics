// RedRect.java: The largest possible rectangle in red.

// Copied from Section 1.1 of
//    Ammeraal, L. and K. Zhang (2007). Computer Graphics for Java Programmers, 2nd Edition,
//       Chichester: John Wiley.

import java.awt.*;
import java.awt.event.*;

public class RedRect extends Frame {
    public static void main(String[] args) {new RedRect();}

    RedRect() {
        super("RedRect");
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {System.exit(0);}
        });
        setSize(300, 150);
        add("Center", new CvRedRect());
        setVisible(true);
    }
}

class CvRedRect extends Canvas {
    public void paint(Graphics g) {
        Dimension d = getSize();
        int maxX = d.width - 1, maxY = d.height - 1;
        g.drawString("d.width  = " + d.width, 10, 30);
        g.drawString("d.height = " + d.height, 10, 60);
        g.setColor(Color.red);
        g.drawRect(0, 0, maxX, maxY);
    }
}