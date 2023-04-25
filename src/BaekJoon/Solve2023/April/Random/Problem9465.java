package BaekJoon.Solve2023.April.Random;

import java.io.*;
import java.util.StringTokenizer;

public class Problem9465 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int testCaseCnt = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCaseCnt; i++) {
            int n = Integer.parseInt(br.readLine());
            int[][] sticker = new int[n][2];

            for (int j = 0; j < 2; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int k = 0; k < n; k++) {
                    sticker[k][j] = Integer.parseInt(st.nextToken());
                }
            }

            int[][] dp = new int[n + 1][2];
            dp[0][0] = 0;
            dp[0][1] = 0;
            dp[1][0] = sticker[0][0];
            dp[1][1] = sticker[0][1];

            for (int j = 2; j <= n; j++) {
                dp[j][0] = Math.max(dp[j - 1][1], dp[j - 2][1]) + sticker[j - 1][0];
                dp[j][1] = Math.max(dp[j - 1][0], dp[j - 2][0]) + sticker[j - 1][1];
            }

            int result = Math.max(dp[n][0], dp[n][1]);
            bw.write(String.valueOf(result));
            bw.newLine();
        }

        br.close();
        bw.close();
    }
}
