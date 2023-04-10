package BaekJoon.Solve2023.April.Random;

import java.io.*;
import java.util.StringTokenizer;

public class Problem16194 {
    int[] dp;
    int[] costArr;
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int purpose = Integer.parseInt(br.readLine());
        costArr = new int[purpose + 1];
        dp = new int[purpose + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= purpose; i++) {
            costArr[i] = Integer.parseInt(st.nextToken());
        }
        dp[1] = costArr[1];

        bw.write(String.valueOf(memoization(purpose)));

        br.close();
        bw.close();
    }

    private int memoization(int num) {
        if (dp[num] > 0) {
            return dp[num];
        }

        int result = Integer.MAX_VALUE;
        for (int i = 1; i < num; i++) {
            result = Math.min(result, memoization(i) + memoization(num - i));
        }

        return dp[num] = Math.min(costArr[num], result);
    }
}
