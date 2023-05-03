package BaekJoon.Solve2023.May.CP_DynamicProgramming;

import java.io.*;
import java.util.StringTokenizer;

public class Problem11055 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int numCnt = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] valArr = new int[numCnt];
        for (int i = 0; i < numCnt; i++) {
            valArr[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[numCnt];
        dp[0] = valArr[0];
        int result = valArr[0];
        for (int i = 1; i < numCnt; i++) {
            int memo = 0;
            for (int j = i - 1; j >= 0; j--) {
                if (valArr[j] < valArr[i]) {
                    memo = Math.max(memo, dp[j]);
                }
            }
            dp[i] = memo + valArr[i];
            result = Math.max(result, dp[i]);
        }

        bw.write(String.valueOf(result));

        br.close();
        bw.close();
    }
}
