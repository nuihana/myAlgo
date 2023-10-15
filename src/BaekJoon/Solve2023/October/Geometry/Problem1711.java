package BaekJoon.Solve2023.October.Geometry;

import java.io.*;
import java.util.*;

public class Problem1711 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        int res = 0;
        for (int i = 0; i < n - 2; i++) {
            int[] p1 = arr[i];
            for (int j = i + 1; j < n - 1; j++) {
                int[] p2 = arr[j];
                for (int k = j + 1; k < n; k++) {
                    int[] p3 = arr[k];
                    if (isOrthogonal(len(p1, p2), len(p1, p3), len(p2, p3))) res++;
                }
            }
        }

        bw.write(String.valueOf(res));

        br.close();
        bw.close();
    }

    private long len(int[] a, int[] b) {
        return (long) (b[0] - a[0]) * (b[0] - a[0]) + (long) (b[1] - a[1]) * (b[1] - a[1]);
    }

    private boolean isOrthogonal(long a, long b, long c) {
        long max = Math.max(a, Math.max(b, c));
        return 2 * max == a + b + c;
    }
}
