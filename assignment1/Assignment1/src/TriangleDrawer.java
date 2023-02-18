import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class TriangleDrawer extends JPanel {

    private Point2D a;
    private Point2D b;
    private Point2D c;
    private Point2D p;

    public TriangleDrawer(Point2D a, Point2D b, Point2D c, Point2D p) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.p = p;
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;

        g2d.setColor(Color.BLACK);
        g2d.draw(new Line2D.Double(a, b));
        g2d.draw(new Line2D.Double(b, c));
        g2d.draw(new Line2D.Double(c, a));

        g2d.setColor(Color.BLUE);
        g2d.fillOval((int) a.getX() - 5, (int) a.getY() - 5, 10, 10);
        g2d.fillOval((int) b.getX() - 5, (int) b.getY() - 5, 10, 10);
        g2d.fillOval((int) c.getX() - 5, (int) c.getY() - 5, 10, 10);

        g2d.setColor(Color.RED);
        g2d.drawLine((int) p.getX() - 5, (int) p.getY(), (int) p.getX() + 5, (int) p.getY());
        g2d.drawLine((int) p.getX(), (int) p.getY() - 5, (int) p.getX(), (int) p.getY() + 5);

        g2d.setColor(Color.BLACK);
        g2d.drawString("A", (int) a.getX() + 5, (int) a.getY() - 5);
        g2d.drawString("B", (int) b.getX() + 5, (int) b.getY() - 5);
        g2d.drawString("C", (int) c.getX() + 5, (int) c.getY() - 5);
    }


    public static void main(String[] args) {
        Point2D a = new Point2D.Double(100, 100);
        Point2D b = new Point2D.Double(200, 150);
        Point2D c = new Point2D.Double(150, 250);
        Point2D p = new Point2D.Double(175, 175);

        JFrame frame = new JFrame("Triangle Drawer");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new TriangleDrawer(a, b, c, p));
        frame.setSize(400, 400);
        frame.setVisible(true);
    }
}
