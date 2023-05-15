package BaekJoon.Solve2023.May.Geometry;

import java.io.*;
import java.util.StringTokenizer;

public class Problem17386 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        Point start0 = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        Point end0 = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

        st = new StringTokenizer(br.readLine());
        Point start1 = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        Point end1 = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

        bw.write(String.valueOf(isCross(start0, end0, start1, end1)));

        br.close();
        bw.close();
    }

    private int outerProduct(Vector vector0, Vector vector1) {
        long result = vector1.vertical * vector0.horizontal - vector1.horizontal * vector0.vertical;

        return Long.signum(result);
    }
    private int isCross(Point start0, Point end0, Point start1, Point end1) {
        Vector l1 = new Vector(start0, end0);

        Vector chkl1_0 = new Vector(start0, start1);
        Vector chkl1_1 = new Vector(start0, end1);

        Vector l2 = new Vector(start1, end1);

        Vector chkl2_0 = new Vector(start1, start0);
        Vector chkl2_1 = new Vector(start1, end0);

        if (outerProduct(l1, chkl1_0) != outerProduct(l1, chkl1_1) && outerProduct(l2, chkl2_0) != outerProduct(l2, chkl2_1)) {
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

    class Vector {
        long horizontal;
        long vertical;

        public Vector(Point p1, Point p2) {
            this.horizontal = p2.x - p1.x;
            this.vertical = p2.y - p1.y;
        }
    }
}
