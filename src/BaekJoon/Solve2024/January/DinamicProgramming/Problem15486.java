package BaekJoon.Solve2024.January.DinamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem15486 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int cnt = Integer.parseInt(br.readLine());
        int[][] counsel = new int[cnt + 2][2];
        for (int i = 1; i <= cnt; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int time = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            counsel[i][0] = time;
            counsel[i][1] = cost;
        }

        int max = -1;
        int[] dp = new int[cnt + 1];
        for (int i = 1; i <= cnt + 1; i++) {
            if (max < dp[i]) max = dp[i];

            int next = i + counsel[i][0];
            if (next < cnt + 2) {
                dp[next] = Math.max(dp[next], max + counsel[i][1]);
            }
        }
        System.out.print(dp[cnt + 1]);

        br.close();
    }
}
