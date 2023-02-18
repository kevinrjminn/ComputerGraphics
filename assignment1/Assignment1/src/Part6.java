import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;

public class Part6 extends Canvas implements MouseListener {

    public JLabel label;
    private Point A, B, C, P;
    private Point nearestPoint;
    private double nearestDistance;

    public Part6() {
        setBackground(Color.WHITE);
        addMouseListener(this);
    }

    public void paint(Graphics g) {
        if (A != null && B != null && C != null) {
            g.setColor(Color.BLACK);
            g.drawLine(A.x, A.y, B.x, B.y);
            g.drawLine(B.x, B.y, C.x, C.y);
            g.drawLine(C.x, C.y, A.x, A.y);
            if (P != null) {
                g.setColor(Color.RED);
                g.drawLine(P.x, P.y, nearestPoint.x, nearestPoint.y);
            }
        }
    }

    public void mouseClicked(MouseEvent e) {
        if (A == null) {
            A = e.getPoint();
        } else if (B == null) {
            B = e.getPoint();
        } else if (C == null) {
            C = e.getPoint();
        } else {
            P = e.getPoint();
            computeNearestPoint();
        }
        repaint();
    }

    public void mousePressed(MouseEvent e) {
    }

    public void mouseReleased(MouseEvent e) {
    }

    public void mouseEntered(MouseEvent e) {
    }

    public void mouseExited(MouseEvent e) {
    }

    private void computeNearestPoint() {
        double distAB = distanceToLine(P, A, B);
        double distBC = distanceToLine(P, B, C);
        double distCA = distanceToLine(P, C, A);
        if (distAB < distBC && distAB < distCA) {
            nearestPoint = nearestPointOnLine(P, A, B);
            nearestDistance = distAB;
        } else if (distBC < distAB && distBC < distCA) {
            nearestPoint = nearestPointOnLine(P, B, C);
            nearestDistance = distBC;
        } else {
            nearestPoint = nearestPointOnLine(P, C, A);
            nearestDistance = distCA;
        }
    }

    private double distanceToLine(Point P, Point Q, Point R) {
        double num = Math.abs((R.y - Q.y) * P.x - (R.x - Q.x) * P.y + R.x * Q.y - R.y * Q.x);
        double den = Math.sqrt((R.y - Q.y) * (R.y - Q.y) + (R.x - Q.x) * (R.x - Q.x));
        return num / den;
    }

    private Point nearestPointOnLine(Point P, Point Q, Point R) {
        double u = ((P.x - Q.x) * (R.x - Q.x) + (P.y - Q.y) * (R.y - Q.y)) / Math.pow(distance(Q, R), 2);
        int x = (int) (Q.x + u * (R.x - Q.x));
        int y = (int) (Q.y + u * (R.y - Q.y));
        return new Point(x, y);
    }

    private double distance(Point P, Point Q) {
        return Math.sqrt((P.x - Q.x) * (P.x - Q.x) + (P.y - Q.y) * (P.y - Q.y));
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Triangle Point Position");
        JPanel panel = new JPanel();
        Part6 canvas = new Part6();
        canvas.setSize(500, 500);
        panel.add(canvas);
        frame.getContentPane().add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 600);
        frame.setVisible(true);
    }
}
