package BaekJoon.Solve2025.November.BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem1418 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());

        int cnt = 0;
        for (int i = 1; i <= n; i++) {
            int now = i, max = 0;
            for (int j = 2; j <= Math.sqrt(i);) {
                if (now % j == 0) {
                    now /= j;
                    max = j;
                } else {
                    j++;
                }
            }

            if (now != 1) max = now;
            if (max <= k) cnt++;
        }
        System.out.print(cnt);

        br.close();
    }
}
