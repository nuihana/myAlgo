package BaekJoon.Solve2023.May.Geometry;

import java.io.*;
import java.util.StringTokenizer;

public class Problem11758 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        Point a = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

        st = new StringTokenizer(br.readLine());
        Point b = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

        st = new StringTokenizer(br.readLine());
        Point c = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

        Vector ab = new Vector(a, b);
        Vector ac = new Vector(a, c);

        int result = ab.outerProduct(ac);
        bw.write(result > 0 ? "1" : result == 0 ? "0" : "-1");

        br.close();
        bw.close();
    }

    class Point {
        int x;
        int y;

        public Point(int x_, int y_) {
            this.x = x_;
            this.y = y_;
        }
    }

    class Vector {
        int x;
        int y;

        public Vector(Point p0, Point p1) {
            this.x = p1.x - p0.x;
            this.y = p1.y - p0.y;
        }

        public int outerProduct(Vector another) {
            return (x * another.y) - (y * another.x);
        }
    }
}
