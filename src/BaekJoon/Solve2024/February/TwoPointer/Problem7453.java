package BaekJoon.Solve2024.February.TwoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Problem7453 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int len = Integer.parseInt(br.readLine());
        int[] a = new int[len];
        int[] b = new int[len];
        int[] c = new int[len];
        int[] d = new int[len];
        for (int i = 0; i < len; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            a[i] = Integer.parseInt(st.nextToken());
            b[i] = Integer.parseInt(st.nextToken());
            c[i] = Integer.parseInt(st.nextToken());
            d[i] = Integer.parseInt(st.nextToken());
        }

        int[][] sum = new int[2][len * len];
        int idx = 0;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                sum[0][idx] = a[i] + b[j];
                sum[1][idx++] = c[i] + d[j];
            }
        }
        Arrays.sort(sum[0]);
        Arrays.sort(sum[1]);

        long res = 0;
        int l = 0;
        int r = sum[0].length - 1;
        int end = len * len;
        while (l < end && 0 <= r) {
            int tmpSum = sum[0][l] + sum[1][r];
            int lCnt = 1;
            int rCnt = 1;
            if (tmpSum == 0) {
                while (l < end - 1 && sum[0][l] == sum[0][l + 1]) {
                    lCnt++;
                    l++;
                }
                while (0 < r && sum[1][r] == sum[1][r - 1]) {
                    rCnt++;
                    r--;
                }
                res += (long) lCnt * rCnt;
            }

            if (tmpSum < 0) l++;
            else r--;
        }
        System.out.print(res);

        br.close();
    }
}
