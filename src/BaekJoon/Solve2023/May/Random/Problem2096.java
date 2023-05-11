package BaekJoon.Solve2023.May.Random;

import java.io.*;
import java.util.StringTokenizer;

public class Problem2096 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int line = Integer.parseInt(br.readLine());
        int[][] arr = new int[line][3];
        int[][][] dp = new int[line + 1][3][2];
        for (int i = 0; i < line; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
            arr[i][2] = Integer.parseInt(st.nextToken());
        }

        for (int i = line - 1; i >= 0; i--) {
            dp[i][0][0] = arr[i][0] + Math.min(dp[i + 1][0][0], dp[i + 1][1][0]);
            dp[i][1][0] = arr[i][1] + Math.min(dp[i + 1][0][0], Math.min(dp[i + 1][1][0], dp[i + 1][2][0]));
            dp[i][2][0] = arr[i][2] + Math.min(dp[i + 1][1][0], dp[i + 1][2][0]);

            dp[i][0][1] = arr[i][0] + Math.max(dp[i + 1][0][1], dp[i + 1][1][1]);
            dp[i][1][1] = arr[i][1] + Math.max(dp[i + 1][0][1], Math.max(dp[i + 1][1][1], dp[i + 1][2][1]));
            dp[i][2][1] = arr[i][2] + Math.max(dp[i + 1][1][1], dp[i + 1][2][1]);
        }

        int minimum = Math.min(dp[0][0][0], Math.min(dp[0][1][0], dp[0][2][0]));
        int maximum = Math.max(dp[0][0][1], Math.max(dp[0][1][1], dp[0][2][1]));

        bw.write(maximum + " " + minimum);

        br.close();
        bw.close();
    }
}
