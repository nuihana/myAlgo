package BaekJoon.Solve2026.April.DinamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem15991 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        long[] dp = new long[100001];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 2;
        dp[4] = 3;
        dp[5] = 3;
        dp[6] = 6;
        for (int i = 7; i <= 100000; i++) {
            dp[i] = (dp[i - 2] + dp[i - 4] + dp[i - 6]) % 1000000009;
        }

        while (n-- > 0) {
            int t = Integer.parseInt(br.readLine());
            sb.append(dp[t]).append("\n");
        }
        System.out.print(sb);

        br.close();
    }
}
