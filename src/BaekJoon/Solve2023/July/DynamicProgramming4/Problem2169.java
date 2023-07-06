package BaekJoon.Solve2023.July.DynamicProgramming4;

import java.io.*;
import java.util.StringTokenizer;

public class Problem2169 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int height = Integer.parseInt(st.nextToken());
        int width = Integer.parseInt(st.nextToken());

        int[][] value = new int[height + 1][width + 1];
        for (int i = 1; i <= height; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= width; j++) {
                value[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] dp = new int[height + 1][width + 1]; // i열 j행에 집입할 수 있는 최대값
        for (int i = 1; i <= width; i++) {
            dp[1][i] = dp[1][i - 1] + value[1][i];
        }
        for (int i = 2; i <= height; i++) {
            int[] left = new int[width + 1];
            int[] right = new int[width + 1];

            left[1] = dp[i - 1][1] + value[i][1];
            right[width] = dp[i - 1][width] + value[i][width];
            for (int j = 2; j <= width; j++) left[j] = Math.max(dp[i - 1][j], left[j - 1]) + value[i][j];
            for (int j = width - 1; j >= 0; j--) right[j] = Math.max(dp[i - 1][j], right[j + 1]) + value[i][j];
            for (int j = 1; j <= width; j++) dp[i][j] = Math.max(left[j], right[j]);
        }

        bw.write(String.valueOf(dp[height][width]));

        br.close();
        bw.close();
    }
}
