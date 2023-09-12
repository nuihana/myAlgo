package BaekJoon.Solve2023.September.Geometry;

import java.io.*;
import java.util.StringTokenizer;

public class Problem11662 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        double ax = Double.parseDouble(st.nextToken());
        double ay = Double.parseDouble(st.nextToken());
        double bx = Double.parseDouble(st.nextToken());
        double by = Double.parseDouble(st.nextToken());
        double cx = Double.parseDouble(st.nextToken());
        double cy = Double.parseDouble(st.nextToken());
        double dx = Double.parseDouble(st.nextToken());
        double dy = Double.parseDouble(st.nextToken());

        int interval = 1000000;

        double ix = (bx - ax) / interval;
        double iy = (by - ay) / interval;
        double jx = (dx - cx) / interval;
        double jy = (dy - cy) / interval;

        int left = 0;
        int right = interval;

        while (right - left >= 3) {
            int l = (2 * left + right) / 3;
            int r = (left + 2 * right) / 3;

            double lVal = getDistance(ax + ix * l, ay + iy * l, cx + jx * l, cy + jy * l);
            double rVal = getDistance(ax + ix * r, ay + iy * r, cx + jx * r, cy + jy * r);

            if (lVal < rVal) right = r - 1;
            else left = l + 1;
        }

        double min = getDistance(ax + ix * right, ay + iy * right, cx + jx * right, cy + jy * right);

        for (int i = left; i < right; i++) {
            double tmp = getDistance(ax + ix * i, ay + iy * i, cx + jx * i, cy + jy * i);

            min = Math.min(min, tmp);
        }

        bw.write(String.valueOf(min));

        br.close();
        bw.close();
    }

    private double getDistance(double x1, double y1, double x2, double y2) {
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }
}
