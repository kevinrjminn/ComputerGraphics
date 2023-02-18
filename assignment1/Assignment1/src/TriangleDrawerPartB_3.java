import java.awt.*;
import javax.swing.*;

public class TriangleDrawerPartB_3 extends JFrame {
    private Point pointA = new Point(100, 100);
    private Point pointB = new Point(300, 100);
    private Point pointC = new Point(200, 300);
    private Point pointP = new Point(150, 100);

    public TriangleDrawerPartB_3() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 500);
        setVisible(true);
    }

    public void paint(Graphics g) {
        super.paint(g);

        // Draw the triangle
        g.setColor(Color.BLACK);
        g.drawLine(pointA.x, pointA.y, pointB.x, pointB.y);
        g.drawLine(pointB.x, pointB.y, pointC.x, pointC.y);
        g.drawLine(pointC.x, pointC.y, pointA.x, pointA.y);

        // Label the points
        g.setColor(Color.BLACK);
        g.drawString("A", pointA.x, pointA.y - 10);
        g.drawString("B", pointB.x, pointB.y - 10);
        g.drawString("C", pointC.x, pointC.y - 10);
        g.drawString("P", pointP.x, pointP.y + 20);

        // Draw point P in a different color depending on whether it's inside, outside, or on an edge of the triangle
        int areaABC = calculateTriangleArea(pointA, pointB, pointC);
        int areaPAB = calculateTriangleArea(pointP, pointA, pointB);
        int areaPBC = calculateTriangleArea(pointP, pointB, pointC);
        int areaPCA = calculateTriangleArea(pointP, pointC, pointA);
        if (areaPAB == 0 || areaPBC == 0 || areaPCA == 0) {
            // Point P is on an edge of triangle ABC
            g.setColor(Color.BLUE);
            g.drawString("Point P is on an edge of triangle ABC", 10, getHeight() - 30);
        } else if (areaABC == areaPAB + areaPBC + areaPCA) {
            // Point P is inside triangle ABC
            g.setColor(Color.GREEN);
        } else {
            // Point P is outside triangle ABC
            g.setColor(Color.RED);
        }
        g.drawLine(pointP.x - 5, pointP.y, pointP.x + 5, pointP.y);
        g.drawLine(pointP.x, pointP.y - 5, pointP.x, pointP.y + 5);
        g.drawString("Point P is on (" + pointP.x + "," + pointP.y + ")", 10, getHeight() - 10);
    }

    private int calculateTriangleArea(Point p1, Point p2, Point p3) {
        return Math.abs((p1.x - p3.x) * (p2.y - p1.y) - (p1.x - p2.x) * (p3.y - p1.y)) / 2;
    }

    public static void main(String[] args) {
        new TriangleDrawerPartB_3();
    }
}
