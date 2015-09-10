
import java.util.*;

class Point {
    int x;
    int y;
    Point() { x = 0; y = 0; }
    Point(int a, int b) { x = a; y = b; }


}

public class MaxPoints {
    /**
     * @param points an array of point
     * @return an integer
     */

    private class Line {
        double k;
        double y;
        double x;
        Line() { k = 0; y = 0; x = 0;}
        Line(double a) {
            x = a;
            y = 1;
        }
        Line(double a, double b) {
            k = a;
            y = b;
            x = 0;

        }

        public String toString() {
            return Double.toString(k) + " " + Double.toString(y) + " " + Double.toString(k);
        }

    }

    public int maxPoints(Point[] points) {
        if (points == null || points.length == 0) {
            return 0;
        }
        if (points.length <= 2) {
            return points.length;
        }

        Hashtable<String, Integer> h = new Hashtable<String, Integer>();

        int max = 0;
        for (int i = 0; i < points.length - 1; i++) {

            int dup = 0;
            h.put("+", 0);
            for (int j = i + 1; j < points.length; j++) {
                Line l;
                if (points[j].x == points[i].x && points[j].y == points[i].y) {
                    dup++;
                    continue;
                }
                if (points[i].x == points[j].x) {
                    l = new Line(points[i].x);
                } else {
                    double k = (points[i].y - points[j].y) * 1.0 / (points[i].x - points[j].x);
                    double y = points[i].y - k * points[i].x;
                    l = new Line(k, y);
                }
                if (h.containsKey(l.toString())) {
                    h.put(l.toString(), h.get(l.toString()) + 1);
                } else {
                    h.put(l.toString(), 1);
                }
            }

            for (int v : h.values()) {
                max = Math.max(max, v+1+dup);
            }
            h.clear();
        }

        return max;
    }

    public static void main(String argv[]) {
        // Point p1 = new Point(1,2);
        Point p2 = new Point(1,1);
        Point p3 = new Point(1,1);
        Point p4 = new Point(1,1);

        Point[] points = {p2, p3, p4};

        MaxPoints m = new MaxPoints();

        System.out.println(m.maxPoints(points));
    }
}
