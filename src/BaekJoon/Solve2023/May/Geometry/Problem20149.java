package BaekJoon.Solve2023.May.Geometry;

import java.io.*;
import java.util.StringTokenizer;

public class Problem20149 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Point[] points = new Point[4];
        StringTokenizer st = new StringTokenizer(br.readLine());
        points[0] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        points[1] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

        st = new StringTokenizer(br.readLine());
        points[2] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        points[3] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

        bw.write(solve(points));

        br.close();
        bw.close();
    }

    private String solve(Point[] p) {
        StringBuilder sb = new StringBuilder();

        int p123 = ccw(p[0], p[1], p[2]);
        int p124 = ccw(p[0], p[1], p[3]);
        int p341 = ccw(p[2], p[3], p[0]);
        int p342 = ccw(p[2], p[3], p[1]);
        int s12 = p123 * p124;
        int s34 = p341 * p342;

        if (s12 <= 0 && s34 < 0 || s12 < 0 && s34 <= 0) {
            sb.append(1).append("\n");
            String t1 = getSlope(p[0], p[1]), t2 = getSlope(p[2], p[3]);
            double x, y;
            if (t1.equals("INF")) {
                x = p[0].x;
                double sl2 = Double.parseDouble(t2);
                y = sl2 * (x - p[2].x) + p[2].y;
            } else if (t2.equals("INF")) {
                x = p[2].x;
                double sl1 = Double.parseDouble(t1);
                y = sl1 * (x - p[0].x) + p[0].y;
            } else {
                double sl1 = Double.parseDouble(t1), sl2 = Double.parseDouble(t2);
                x = (sl1 * p[0].x - sl2 * p[2].x + p[2].y - p[0].y) / (sl1 - sl2);
                y = sl1 * (x - p[0].x) + p[0].y;
            }
            sb.append(x).append(' ').append(y);
        } else if (s12 == 0 && s34 == 0) {
            if (p123 == 0 && p124 == 0 && p341 == 0 && p342 == 0) {
                int n = isCrossed(p);
                if (n > 0)
                    sb.append(1);
                else
                    sb.append(0);

                if (n == 2) {
                    sb.append('\n');
                    if (p[0].x == p[2].x && p[0].y == p[2].y || p[0].x == p[3].x && p[0].y == p[3].y)
                        sb.append(p[0].x).append(' ').append(p[0].y);
                    else if (p[1].x == p[2].x && p[1].y == p[2].y || p[1].x == p[3].x && p[1].y == p[3].y)
                        sb.append(p[1].x).append(' ').append(p[1].y);
                }
            } else {
                sb.append(1).append('\n');
                if (p[0].x == p[2].x && p[0].y == p[2].y || p[0].x == p[3].x && p[0].y == p[3].y)
                    sb.append(p[0].x).append(' ').append(p[0].y);
                else if (p[1].x == p[2].x && p[1].y == p[2].y || p[1].x == p[3].x && p[1].y == p[3].y)
                    sb.append(p[1].x).append(' ').append(p[1].y);
            }
        } else {
            sb.append(0);
        }

        return sb.toString();
    }
    private int ccw(Point p1, Point p2, Point p3) {
        long result = ((long)p1.x * p2.y + (long)p2.x * p3.y + (long)p3.x * p1.y)
                - ((long)p1.y * p2.x + (long)p2.y * p3.x + (long)p3.y * p1.x);

        return result > 0 ? 1: result < 0 ? -1 : 0;
    }
    private String getSlope(Point p1, Point p2) {
        if (p1.x == p2.x) {
            return "INF";
        }
        double s = ((double) p2.y -  p1.y) / (p2.x - p1.x);
        return String.valueOf(s);
    }
    private int isCrossed(Point[] p) {
        int a, b, c, d;
        if (p[0].x == p[1].x) {
            a = Math.min(p[0].y, p[1].y);
            b = Math.max(p[0].y, p[1].y);
            c = Math.min(p[2].y, p[3].y);
            d = Math.max(p[2].y, p[3].y);
        } else {
            a = Math.min(p[0].x, p[1].x);
            b = Math.max(p[0].x, p[1].x);
            c = Math.min(p[2].x, p[3].x);
            d = Math.max(p[2].x, p[3].x);
        }

        if (a == d || b == c) {
            return 2;
        } else if (a < d && c < b) {
            return 1;
        } else {
            return 0;
        }
    }

    class Point {
        int x;
        int y;

        public Point(int x_, int y_) {
            this.x = x_;
            this.y = y_;
        }
    }
}
