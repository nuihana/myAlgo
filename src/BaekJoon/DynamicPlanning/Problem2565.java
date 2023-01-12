package BaekJoon.DynamicPlanning;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Problem2565 {
    private Integer[] dp;
    private int[][] wire;
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int input = Integer.parseInt(br.readLine());

        dp = new Integer[input];
        wire = new int[input][2];

        for (int i = 0; i < input; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            wire[i][0] = Integer.parseInt(st.nextToken());
            wire[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(wire, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        int max = 0;
        for (int i = 0; i < input; i++) {
            max = Math.max(recur(i), max);
        }

        System.out.println(input - max);

        br.close();
    }

    private int recur(int N) {
        if (dp[N] == null) {
            dp[N] = 1;
            for (int i = N + 1; i < dp.length; i++) {
                if (wire[N][1] < wire[i][1]) {
                    dp[N] = Math.max(dp[N], recur(i) + 1);
                }
            }
        }
        return dp[N];
    }
}
