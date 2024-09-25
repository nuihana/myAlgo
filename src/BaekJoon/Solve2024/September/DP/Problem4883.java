package BaekJoon.Solve2024.September.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem4883 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int nth = 1;
        StringBuilder sb = new StringBuilder();
        while (true) {
            int row = Integer.parseInt(br.readLine());
            if (row == 0) break;

            int[][] cost = new int[row][3];
            for (int i = 0; i < row; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());

                cost[i][0] = Integer.parseInt(st.nextToken());
                cost[i][1] = Integer.parseInt(st.nextToken());
                cost[i][2] = Integer.parseInt(st.nextToken());
            }

            int[][] dp = new int[row][3];
            dp[row - 1][0] = cost[row - 1][0] + cost[row - 1][1];
            dp[row - 1][1] = cost[row - 1][1];
            dp[row - 1][2] = 100000000;

            for (int i = row - 2; i >= 0; i--) {
                dp[i][2] = cost[i][2] + Math.min(dp[i + 1][1], dp[i + 1][2]);
                dp[i][1] = cost[i][1] + Math.min(dp[i][2], Math.min(dp[i + 1][2], Math.min(dp[i + 1][1], dp[i + 1][0])));
                dp[i][0] = cost[i][0] + Math.min(dp[i][1], Math.min(dp[i + 1][0], dp[i + 1][1]));
            }

            sb.append(nth++).append(". ").append(dp[0][1]).append("\n");
        }
        System.out.print(sb);

        br.close();
    }
}
