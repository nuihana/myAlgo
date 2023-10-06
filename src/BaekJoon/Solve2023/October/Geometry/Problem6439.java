package BaekJoon.Solve2023.October.Geometry;

import java.io.*;
import java.util.StringTokenizer;

public class Problem6439 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int[] l1 = new int[]{ Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()) };
            int[] l2 = new int[]{ Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()) };
            int lMinX = Math.min(l1[0], l2[0]);
            int lMinY = Math.min(l1[1], l2[1]);
            int lMaxX = Math.max(l1[0], l2[0]);
            int lMaxY = Math.max(l1[1], l2[1]);

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int spMinX = Math.min(a, c);
            int spMinY = Math.min(b, d);
            int spMaxX = Math.max(a, c);
            int spMaxY = Math.max(b, d);

            if (isCrossed(new int[]{ a,b }, new int[]{ a,d }, l1, l2)) {
                bw.write("T");
                bw.newLine();
                continue;
            }
            if (isCrossed(new int[]{ a,b }, new int[]{ c,b }, l1, l2)) {
                bw.write("T");
                bw.newLine();
                continue;
            }
            if (isCrossed(new int[]{ c,d }, new int[]{ c,b }, l1, l2)) {
                bw.write("T");
                bw.newLine();
                continue;
            }
            if (isCrossed(new int[]{ a,d }, new int[]{ c,d }, l1, l2)) {
                bw.write("T");
                bw.newLine();
                continue;
            }
            if (spMinX <= lMinX && lMaxX <= spMaxX && spMinY <= lMinY && lMaxY <= spMaxY) {
                bw.write("T");
                bw.newLine();
                continue;
            }
            bw.write("F");
            bw.newLine();
        }

        br.close();
        bw.close();
    }

    private int ccw(int[] a, int[] b, int[] c) {
        return Integer.signum((b[0] - a[0]) * (c[1] - a[1]) - (c[0] - a[0]) * (b[1] - a[1]));
    }

    private boolean isCrossed(int[] p1, int[] p2, int[] p3, int[] p4) {
        int p123 = ccw(p1, p2, p3);
        int p124 = ccw(p1, p2, p4);
        int p341 = ccw(p3, p4, p1);
        int p342 = ccw(p3, p4, p2);

        if (p123 == 0 && p124 == 0 && p341 == 0 && p342 == 0) {
            if (Math.min(p1[0], p2[0]) > Math.max(p3[0], p4[0]) ||
                    Math.min(p1[1], p2[1]) > Math.max(p3[1], p4[1]) ||
                    Math.min(p3[0], p4[0]) > Math.max(p1[0], p2[0]) ||
                    Math.min(p3[1], p4[1]) > Math.max(p1[1], p2[1])) return false;
        }

        return p123 * p124 <= 0 && p341 * p342 <= 0;
    }
}
