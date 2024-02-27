package BaekJoon.Solve2024.February.DinamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Problem14916 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int changes = Integer.parseInt(br.readLine());
        int[] dp = new int[100001];
        Arrays.fill(dp, -1);
        dp[2] = 1;
        dp[4] = 2;
        dp[5] = 1;
        for (int i = 6; i <= changes; i++) {
            int two = dp[i - 2];
            int five = dp[i - 5];

            if (two > 0 && five > 0) {
                dp[i] = Math.min(two, five) + 1;
            } else if (two > 0) {
                dp[i] = two + 1;
            } else if (five > 0) {
                dp[i] = five + 1;
            } else {
                dp[i] = -1;
            }
        }
        System.out.print(dp[changes]);

        br.close();
    }
}
