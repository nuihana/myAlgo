package BaekJoon.Solve2023.May.Geometry;

import java.io.*;
import java.util.*;

public class Problem2162 {
    int[] unionFind;
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int lineCnt = Integer.parseInt(br.readLine());
        Line[] lineArr = new Line[lineCnt + 1];
        unionFind = new int[lineCnt + 1];
        for (int i = 1; i <= lineCnt; i++) {
            unionFind[i] = i;
            StringTokenizer st = new StringTokenizer(br.readLine());

            Point p0 = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            Point p1 = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

            lineArr[i] = new Line(p0, p1);
        }

        for (int i = 1; i <= lineCnt; i++) {
            Line current = lineArr[i];
            for (int j = i + 1; j <= lineCnt; j++) {
                if (current.isCross(lineArr[j])) {
                    union(i, j);
                }
            }
        }

        Map<Integer, Integer> groupMap = new HashMap<>();
        for (int i = 1; i <= lineCnt; i++) {
            int root = find(i);
            if (groupMap.get(root) == null) {
                groupMap.put(root, 1);
            } else {
                groupMap.put(root, groupMap.get(root) + 1);
            }
        }

        bw.write(String.valueOf(groupMap.keySet().size()));
        bw.newLine();
        int maxCnt = 0;
        for (int key : groupMap.keySet()) {
            maxCnt = Math.max(maxCnt, groupMap.get(key));
        }
        bw.write(String.valueOf(maxCnt));

        br.close();
        bw.close();
    }

    private int find(int idx) {
        while(unionFind[idx] != idx) {
            idx = unionFind[idx];
        }
        return idx;
    }
    private void union(int a, int b) {
        int root_a = find(a);
        int root_b = find(b);

        if (root_b != root_a) {
            unionFind[root_b] = root_a;
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

    class Line {
        Point start;
        Point end;

        public Line(Point p0, Point p1) {
            this.start = p0;
            this.end = p1;
        }

        private int ccw(Point p1, Point p2, Point p3) {
            long result = ((long)p1.x * p2.y + (long)p2.x * p3.y + (long)p3.x * p1.y)
                    - ((long)p1.y * p2.x + (long)p2.y * p3.x + (long)p3.y * p1.x);
            return Long.signum(result);
        }
        private int isCrossed(Point p1, Point p2, Point p3, Point p4) {
            int a, b, c, d;
            if (p1.x == p2.x) {
                a = Math.min(p1.y, p2.y);
                b = Math.max(p1.y, p2.y);
                c = Math.min(p3.y, p4.y);
                d = Math.max(p3.y, p4.y);
            } else {
                a = Math.min(p1.x, p2.x);
                b = Math.max(p1.x, p2.x);
                c = Math.min(p3.x, p4.x);
                d = Math.max(p3.x, p4.x);
            }

            if (a == d || b == c) {
                return 2;
            } else if (a < d && c < b) {
                return 1;
            } else {
                return 0;
            }
        }

        public boolean isCross(Line another) {
            int p123 = ccw(start, end, another.start);
            int p124 = ccw(start, end, another.end);
            int p341 = ccw(another.start, another.end, start);
            int p342 = ccw(another.start, another.end, end);
            int s12 = p123 * p124;
            int s34 = p341 * p342;

            if (s12 <= 0 && s34 < 0 || s12 < 0 && s34 <= 0) {
                return true;
            } else if (s12 == 0 && s34 == 0) {
                if (p123 == 0 && p124 == 0 && p341 == 0 && p342 == 0) {
                    return isCrossed(start, end, another.start, another.end) > 0;
                } else {
                    return true;
                }
            }
            return false;
        }
    }
}
