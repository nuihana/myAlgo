package BaekJoon.Solve2023.September.Geometry;

import java.io.*;
import java.util.StringTokenizer;

public class Problem11664 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        double ax = Double.parseDouble(st.nextToken());
        double ay = Double.parseDouble(st.nextToken());
        double az = Double.parseDouble(st.nextToken());
        double bx = Double.parseDouble(st.nextToken());
        double by = Double.parseDouble(st.nextToken());
        double bz = Double.parseDouble(st.nextToken());
        double cx = Double.parseDouble(st.nextToken());
        double cy = Double.parseDouble(st.nextToken());
        double cz = Double.parseDouble(st.nextToken());

        int interval = 1000000;

        double ix = (bx - ax) / interval;
        double iy = (by - ay) / interval;
        double iz = (bz - az) / interval;

        int l = 0;
        int r = interval;
        while (r - l >= 3) {
            int p = (l * 2 + r) / 3;
            int q = (l + r * 2) / 3;

            double pVal = getDistance(ax + ix * p, ay + iy * p, az + iz * p, cx, cy, cz);
            double qVal = getDistance(ax + ix * q, ay + iy * q, az + iz * q, cx, cy, cz);

            if (pVal < qVal) r = q - 1;
            else l = p + 1;
        }

        double min = getDistance(ax + ix * r, ay + iy * r, az + iz * r, cx, cy, cz);

        for (int i = l; i < r; i++) {
            double tmp = getDistance(ax + ix * i, ay + iy * i, az + iz * i, cx, cy, cz);

            min = Math.min(min, tmp);
        }

        bw.write(String.valueOf(min));

        br.close();
        bw.close();
    }

    private double getDistance(double x1, double y1, double z1, double x2, double y2, double z2) {
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2) + Math.pow(z2 - z1, 2));
    }
}
