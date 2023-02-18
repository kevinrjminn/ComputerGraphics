import java.awt.geom.Point2D;

public class PointOnSegmentChecker {

    public static boolean isPointOnSegment(Point2D p, Point2D a, Point2D b) {
        double dotProduct = (p.getX() - a.getX()) * (b.getX() - a.getX()) + (p.getY() - a.getY()) * (b.getY() - a.getY());
        double segmentLength = a.distance(b);
        double projection = dotProduct / (segmentLength * segmentLength);

        if (projection < 0 || projection > 1) {
            // The projection of p is outside the segment AB.
            return false;
        } else {
            // The projection of p is on the segment AB.
            return true;
        }
    }

    public static void main(String[] args) {
        Point2D p = new Point2D.Double(2.5, 3.5);
        Point2D a = new Point2D.Double(1.0, 1.0);
        Point2D b = new Point2D.Double(4.0, 4.0);

        boolean result = isPointOnSegment(p, a, b);
        System.out.println("Point " + p + " is on segment AB: " + result);
    }

}
