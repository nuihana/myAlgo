package BaekJoon.Solve2023.July.Geometry;

import java.io.*;
import java.util.StringTokenizer;

public class Problem1064 {
    double[] res;
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] a = {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
        int[] b = {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
        int[] c = {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
        int[] d;

        if (isLine(a, b, c)) {
            bw.write("-1");
        } else {
            double abPow = getLen(a, b);
            double acPow = getLen(a, c);
            double bcPow = getLen(b, c);
            res = new double[2]; // 0 : 최소값, 1: : 최대값
            res[0] = 100000000; // INF set
            //cd
            int dx = b[0] - a[0];
            int dy = b[1] - a[1];
            d = new int[]{c[0] + dx, c[1] + dy};
            updateResult(getLen(c, d) + abPow); // a > b 방향
            dx = -dx;
            dy = -dy;
            d = new int[]{c[0] + dx, c[1] + dy};
            updateResult(getLen(c, d) + abPow); // b > a 방향
            //bd
            dx = c[0] - a[0];
            dy = c[1] - a[1];
            d = new int[]{b[0] + dx, b[1] + dy};
            updateResult(getLen(b, d) + acPow); // a > c 방향
            dx = -dx;
            dy = -dy;
            d = new int[]{b[0] + dx, b[1] + dy};
            updateResult(getLen(b, d) + acPow); // c > a 방향
            //ad
            dx = c[0] - b[0];
            dy = c[1] - b[1];
            d = new int[]{a[0] + dx, a[1] + dy};
            updateResult(getLen(a, d) +  bcPow); // b > c 방향
            dx = -dx;
            dy = -dy;
            d = new int[]{a[0] + dx, a[1] + dy};
            updateResult(getLen(a, d) +  bcPow); // c > b 방향

            bw.write(String.valueOf(res[1] - res[0]));
        }

        br.close();
        bw.close();
    }

    private double getLen(int[] p1, int[] p2) {
        return Math.sqrt(Math.pow(p2[0] - p1[0], 2) + Math.pow(p2[1] - p1[1], 2));
    }

    private void updateResult(double val) {
        res[0] = Math.min(res[0], val);
        res[1] = Math.max(res[1], val);
    }

    private boolean isLine(int[] a, int[] b, int[] c) {
        int abdx = b[0] - a[0];
        int abdy = b[1] - a[1];

        int bcdx = c[0] - b[0];
        int bcdy = c[1] - b[1];

        return abdy * bcdx == bcdy * abdx;
    }
}
