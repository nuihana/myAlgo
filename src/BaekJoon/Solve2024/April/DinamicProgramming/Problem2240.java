package BaekJoon.Solve2024.April.DinamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem2240 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int time = Integer.parseInt(st.nextToken());
        int move = Integer.parseInt(st.nextToken());
        int[] schedule = new int[time + 1];
        for (int i = 1; i <= time; i++) {
            schedule[i] = Integer.parseInt(br.readLine());
        }

        int[][][] dp = new int[time + 1][move + 1][3];
        int res = 0;
        for (int i = 1; i <= time; i++) {
            for (int j = 0; j <= move; j++) {
                if (schedule[i] == 1) {
                    if (j == 0) {
                        dp[i][j][1] = dp[i - 1][j][1] + 1;
                        continue;
                    }
                    dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j - 1][2]) + 1;
                    dp[i][j][2] = Math.max(dp[i - 1][j][2], dp[i - 1][j - 1][1]);
                    res = Math.max(dp[i][j][1], dp[i][j][2]);
                } else {
                    if (j == 0) {
                        dp[i][j][1] = dp[i - 1][j][1];
                        continue;
                    }
                    dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j - 1][2]);
                    dp[i][j][2] = Math.max(dp[i - 1][j][2], dp[i - 1][j - 1][1]) + 1;
                    res = Math.max(dp[i][j][1], dp[i][j][2]);
                }
            }
        }
        System.out.print(res);

        br.close();
    }
}
