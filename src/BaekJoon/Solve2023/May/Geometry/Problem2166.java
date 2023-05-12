package BaekJoon.Solve2023.May.Geometry;

import java.io.*;
import java.util.StringTokenizer;

public class Problem2166 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int pointCnt = Integer.parseInt(br.readLine());
        Point[] pointArr = new Point[pointCnt];

        for (int i = 0; i < pointCnt; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            pointArr[i] = new Point(Long.parseLong(st.nextToken()), Long.parseLong(st.nextToken()));
        }

        double result = 0;
        for (int i = 0, j = pointCnt - 1; i < pointCnt; i++) {
            result += (pointArr[j].x + pointArr[i].x) * (pointArr[j].y - pointArr[i].y);
            j = i;
        }
        result /= 2;

        bw.write(String.format("%.1f", Math.abs(result)));

        br.close();
        bw.close();
    }

    class Point {
        long x;
        long y;

        public Point(long x_, long y_) {
            this.x = x_;
            this.y = y_;
        }
    }
}
