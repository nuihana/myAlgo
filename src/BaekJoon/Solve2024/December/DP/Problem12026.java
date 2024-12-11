package BaekJoon.Solve2024.December.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Problem12026 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        char[] block = br.readLine().toCharArray();
        int[] dp = new int[n];
        Arrays.fill(dp, 987654321);

        dp[0] = 0;
        for (int i = 0; i < n - 1; i++) {
            char now = block[i];
            if (now == 'B') {
                for (int j = i + 1; j < n; j++) {
                    if (block[j] == 'O') {
                        dp[j] = Math.min(dp[j], dp[i] + (j - i) * (j - i));
                    }
                }
            } else if (now == 'O') {
                for (int j = i + 1; j < n; j++) {
                    if (block[j] == 'J') {
                        dp[j] = Math.min(dp[j], dp[i] + (j - i) * (j - i));
                    }
                }
            } else if (now == 'J') {
                for (int j = i + 1; j < n; j++) {
                    if (block[j] == 'B') {
                        dp[j] = Math.min(dp[j], dp[i] + (j - i) * (j - i));
                    }
                }
            }
        }

        System.out.print(dp[n - 1] == 987654321 ? -1 : dp[n - 1]);

        br.close();
    }
}
