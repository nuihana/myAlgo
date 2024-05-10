package BaekJoon.Solve2024.May.DinamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Problem2302 {
    Integer[][] dp;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int seatCnt = Integer.parseInt(br.readLine());
        int vipCnt = Integer.parseInt(br.readLine());

        Queue<Integer> vipQ = new LinkedList<>();
        for (int i = 0; i < vipCnt; i++) {
            int vip = Integer.parseInt(br.readLine());
            vipQ.offer(vip);
        }

        dp = new Integer[41][2];
        dp[0][0] = 1;
        dp[0][1] = 0;
        dp[1][0] = 1;
        dp[1][1] = 1;

        int res = 1;
        int l = 1;
        while (!vipQ.isEmpty()) {
            int now = vipQ.poll();

            int size = now - l - 1;
            l = now + 1;
            if (size < 0) continue;

            res *= (memoization(size, 0) + memoization(size, 1));
        }

        if (l < seatCnt) {
            int size = seatCnt - l;

            res *= (memoization(size, 0) + memoization(size, 1));
        }

        System.out.print(res);

        br.close();
    }

    private int memoization(int n, int i) {
        if (dp[n][i] != null) return dp[n][i];

        if (i == 0) {
            return dp[n][0] = memoization(n - 1, 0) + memoization(n - 1, 1);
        } else {
            return dp[n][1] = memoization(n - 1, 0);
        }
    }
}
