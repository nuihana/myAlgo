package BaekJoon.Solve2023.March.DinamicPlanning;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem12865 {
    private int[][] worth;
    private Integer[][] dp;
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int stuffCnt = Integer.parseInt(st.nextToken());
        int maxWeight = Integer.parseInt(st.nextToken());

        worth = new int[stuffCnt][2];
        dp = new Integer[stuffCnt][maxWeight + 1];

        for (int i = 0; i < stuffCnt; i++) {
            st = new StringTokenizer(br.readLine());

            worth[i][0] = Integer.parseInt(st.nextToken());
            worth[i][1] = Integer.parseInt(st.nextToken());
        }

        System.out.println(getMaximumWorthSum(stuffCnt - 1, maxWeight));

        br.close();
    }

    private int getMaximumWorthSum(int idx, int empty) {
        if (idx < 0) {
            return 0;
        }

        if (dp[idx][empty] == null) {
            if (worth[idx][0] > empty) {
                dp[idx][empty] = getMaximumWorthSum(idx - 1, empty);
            } else {
                dp[idx][empty] = Math.max(getMaximumWorthSum(idx - 1, empty), getMaximumWorthSum(idx - 1, empty - worth[idx][0]) + worth[idx][1]);
            }
        }

        return dp[idx][empty];
    }
}
