package BaekJoon.Solve2023.May.DynamicProgramming3;

import java.io.*;
import java.util.StringTokenizer;

public class Problem17404 {
    int homeCnt;
    int[][] costArr;
    int[][] dp;
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        homeCnt = Integer.parseInt(br.readLine());
        costArr = new int[homeCnt][3];
        for (int i = 0; i < homeCnt; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            costArr[i][0] = Integer.parseInt(st.nextToken());
            costArr[i][1] = Integer.parseInt(st.nextToken());
            costArr[i][2] = Integer.parseInt(st.nextToken());
        }

        int result = Integer.MAX_VALUE;
        for (int i = 0; i < 3; i++) {
            dp = new int[homeCnt][3];
            result = Math.min(result, memoization(0, i, i));
        }
        bw.write(String.valueOf(result));

        br.close();
        bw.close();
    }

    private int memoization(int idx, int color, int origin) {
        if (idx == homeCnt - 1) return color == origin ? 1000000 : costArr[idx][color];
        if (dp[idx][color] > 0) return dp[idx][color];

        dp[idx][color] = Integer.MAX_VALUE;
        for (int i = 0; i < 3; i++) {
            if (i != color) {
                dp[idx][color] = Math.min(dp[idx][color], memoization(idx + 1, i, origin) + costArr[idx][color]);
            }
        }
        return dp[idx][color];
    }
}
