import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TrianglePointPosition extends Canvas implements MouseListener {

    private Point A, B, C, P;
    private JLabel label;

    public TrianglePointPosition() {
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
                g.drawLine(P.x - 5, P.y - 5, P.x + 5, P.y + 5);
                g.drawLine(P.x + 5, P.y - 5, P.x - 5, P.y + 5);
                String position = getPosition(P, A, B, C);
                label.setText(position);
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

    private String getPosition(Point P, Point A, Point B, Point C) {
        double signAB = (P.x - A.x) * (B.y - A.y) - (P.y - A.y) * (B.x - A.x);
        double signBC = (P.x - B.x) * (C.y - B.y) - (P.y - B.y) * (C.x - B.x);
        double signCA = (P.x - C.x) * (A.y - C.y) - (P.y - C.y) * (A.x - C.x);
        if (signAB > 0 && signBC > 0 && signCA > 0) {
            return "P is inside ABC";
        } else if (signAB < 0 && signBC < 0 && signCA < 0) {
            return "P is inside ABC";
        } else if (signAB == 0 && onSegment(P, A, B)) {
            return "P is on edge AB";
        } else if (signBC == 0 && onSegment(P, B, C)) {
            return "P is on edge BC";
        } else if (signCA == 0 && onSegment(P, C, A)) {
            return "P is on edge CA";
        } else {
            return "P is outside ABC";
        }
    }

    private boolean onSegment(Point P, Point Q, Point R) {
        return P.x >= Math.min(Q.x, R.x) && P.x <= Math.max(Q.x, R.x)
                && P.y >= Math.min(Q.y, R.y) && P.y <= Math.max(Q.y, R.y);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Triangle Point Position");
        JPanel panel = new JPanel();
        Part6 canvas = new Part6();
        canvas.setSize(500, 500);
        panel.add(canvas);
        canvas.label = new JLabel();
        panel.add(canvas.label);
        frame.getContentPane().add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 600);
        frame.setVisible(true);
    }
}
