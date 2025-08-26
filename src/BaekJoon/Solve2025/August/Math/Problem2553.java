package BaekJoon.Solve2025.August.Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem2553 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[20001];
        dp[0] = dp[1] = 1;
        dp[2] = 2;
        dp[3] = 6;
        dp[4] = 4;

        for (int i = 5; i <= n; i++) {
            if (i % 5 == 0) {
                int q = i / 5;
                dp[i] = ((int) Math.pow(2, q % 4) * dp[q]) % 10;
            } else {
                int bf = (i / 5) * 5;
                int tot = 1;
                for (int j = i; j > bf; j--) {
                    tot *= (j % 10);
                }
                tot *= dp[bf];
                dp[i] = tot % 10;
            }
        }

        System.out.print(dp[n]);

        br.close();
    }
}
