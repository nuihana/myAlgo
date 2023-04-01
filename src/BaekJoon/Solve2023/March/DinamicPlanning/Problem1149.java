package BaekJoon.Solve2023.March.DinamicPlanning;

import java.io.*;
import java.util.StringTokenizer;

public class Problem1149 {
    final int Red = 0;
    final int Green = 1;
    final int Blue = 2;
    private int[][] cost;
    private int[][] dp;
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int inputCnt = Integer.parseInt(br.readLine());
        cost = new int[inputCnt][3];
        dp = new int[inputCnt][3];

        for (int i = 0; i < inputCnt; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            cost[i][Red] = Integer.parseInt(st.nextToken());
            cost[i][Green] = Integer.parseInt(st.nextToken());
            cost[i][Blue] = Integer.parseInt(st.nextToken());
        }

        dp[0][Red] = cost[0][Red];
        dp[0][Green] = cost[0][Green];
        dp[0][Blue] = cost[0][Blue];

        bw.write(Math.min(paintCost(inputCnt - 1, Red), Math.min(paintCost(inputCnt - 1, Green), paintCost(inputCnt - 1, Blue))));

        br.close();
        bw.close();
    }

    private int paintCost(int n, int color) {
        if (dp[n][color] == 0) {
            if (color == Red) {
                dp[n][Red] = Math.min(paintCost(n - 1, Green), paintCost(n - 1, Blue)) + cost[n][Red];
            } else if (color == Green) {
                dp[n][Green] = Math.min(paintCost(n - 1, Red), paintCost(n - 1, Blue)) + cost[n][Green];
            } else {
                dp[n][Blue] = Math.min(paintCost(n - 1, Red), paintCost(n - 1, Green)) + cost[n][Blue];
            }
        }

        return dp[n][color];
    }
}
