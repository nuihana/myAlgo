package BaekJoon.Solve2023.May.DynamicProgramming3;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem2098 {
    int cityCnt;
    int[][] cost;
    int[][] dp;
    final int NOTCYCLE = 16000000;
    final int NOTVISIT = NOTCYCLE * 2;
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        cityCnt = Integer.parseInt(br.readLine());
        cost = new int[cityCnt][cityCnt];
        dp = new int[cityCnt][(1 << cityCnt)];
        for (int i = 0; i < cityCnt; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < cityCnt; j++) {
                cost[i][j] = Integer.parseInt(st.nextToken());
            }
            Arrays.fill(dp[i], NOTVISIT);
        }

        bw.write(String.valueOf(memoization(0, 1)));

        br.close();
        bw.close();
    }

    private int memoization(int idx, int bitIdx) {
        bitIdx = bitIdx | (1 << idx);

        if (bitIdx == (1 << cityCnt) - 1) {
            if (cost[idx][0] == 0) {
                return NOTCYCLE;
            }

            return cost[idx][0];
        }

        if (dp[idx][bitIdx] != NOTVISIT) return dp[idx][bitIdx];

        for (int i = 0; i < cityCnt; i++) {
            if ((bitIdx & (1 << i)) == 0 && cost[idx][i] != 0) {
                int temp = memoization(i, bitIdx) + cost[idx][i];
                if (dp[idx][bitIdx] > temp) {
                    dp[idx][bitIdx] = temp;
                }
            }
        }

        return dp[idx][bitIdx];
    }
}
