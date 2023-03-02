package BaekJoon.Solve2023.DinamicPlanning2nd;

import java.io.*;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Problem11066 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int testCase = Integer.parseInt(br.readLine());

        for (int i = 0; i < testCase; i++) {
            int arrCnt = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());

            int[] arr = new int[arrCnt];

            for (int j = 0; st.hasMoreTokens(); j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }

            int[] sum = new int[arrCnt];
            sum[0] = arr[0];
            for (int j = 1; j < arrCnt; j++) {
                sum[j] = sum[j - 1] + arr[j];
            }

            bw.write(String.valueOf(getMinimumTime(arr, sum)));
            bw.newLine();
        }

        br.close();
        bw.close();
    }

    private int getMinimumTime(int[] files, int[] sum) {
        int[][] dp = new int[files.length][files.length];

        for (int i = 0; i < dp.length - 1; i++) {
            dp[i][i + 1] = files[i] + files[i + 1];
        }

        for (int j = 2; j < dp.length; j++) {
            for(int i = 0; i + j < dp.length; i++) {
                for (int k = i; k < i + j; k++) {
                    if (dp[i][i + j] == 0) {
                        dp[i][i + j] = dp[i][k]+ dp[k + 1][i + j] + sumDist(sum, i, i + j);
                    } else {
                        dp[i][i + j] = Math.min(dp[i][i + j], dp[i][k] + dp[k + 1][i + j] + sumDist(sum, i, i + j));
                    }
                }
            }
        }

        return dp[0][dp.length - 1];
    }

    private int sumDist(int[] sum, int start, int end) {
        if (start == 0) {
            return sum[end];
        }

        return sum[end] - sum[start - 1];
    }
}
