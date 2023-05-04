package BaekJoon.Solve2023.May.CP_DynamicProgramming;

import java.io.*;
import java.util.*;

public class Problem13398 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int numCnt = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] numArr = new int[numCnt];
        for (int i = 0; i < numCnt; i++) {
            numArr[i] = Integer.parseInt(st.nextToken());
        }

        int[][] dp = new int[numCnt][2];
        dp[0][0] = numArr[0];
        int maximum = dp[0][0];
        for (int i = 1; i < numCnt; i++) {
            dp[i][0] = Math.max(numArr[i], dp[i - 1][0] + numArr[i]);
            maximum = Math.max(maximum, dp[i][0]);
        }

        dp[numCnt - 1][1] = numArr[numCnt - 1];
        for (int i = numCnt - 2; i >= 0; i--) {
            dp[i][1] = Math.max(dp[i + 1][1] + numArr[i], numArr[i]);
        }

        for (int i = 1; i < numCnt - 1; i++) {
            maximum = Math.max(maximum, dp[i - 1][0] + dp[i + 1][1]);
        }

        bw.write(String.valueOf(maximum));

        br.close();
        bw.close();
    }
}
