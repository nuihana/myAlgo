package BaekJoon.Solve2023.May.DynamicProgramming3;

import java.io.*;
import java.util.*;

public class Problem1311 {
    int size;
    int[][] cost;
    int[][] dp;
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        size = Integer.parseInt(br.readLine());
        cost = new int[size][size];
        dp = new int[size][(int) Math.pow(2, size + 1)];

        for (int i = 0; i < size; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < size; j++) {
                cost[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        bw.write(String.valueOf(memoization(0, 0)));

        br.close();
        bw.close();
    }

    private int memoization(int idx, int bitIdx) {
        if (bitIdx == (1 << size) - 1) return 0; // 탐색완료
        if (dp[idx][bitIdx] > 0) return dp[idx][bitIdx];

        dp[idx][bitIdx] = Integer.MAX_VALUE;
        for (int i = 0; i < size; i++) {
            if ((bitIdx & (1 << i)) != 0) continue;

            dp[idx][bitIdx] = Math.min(dp[idx][bitIdx], memoization(idx + 1, bitIdx | (1 << i)) + cost[idx][i]);
        }
        return dp[idx][bitIdx];
    }
}
