package BaekJoon.Solve2024.June.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem10164 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int height = Integer.parseInt(st.nextToken());
        int width = Integer.parseInt(st.nextToken());
        int via = Integer.parseInt(st.nextToken()) - 1;

        Integer[][] dp = new Integer[height][width];

        dp[0][0] = 1;
        int x = height - 1;
        int y = width - 1;
        int res = 1;
        if (via != -1) {
            int vx = via / width;
            int vy = via % width;

            x -= vx;
            y -= vy;

            res = memoization(dp, vx, vy);
        }

        res *= memoization(dp, x, y);
        System.out.print(res);

        br.close();
    }

    private int memoization(Integer[][] dp, int x, int y) {
        if (x < 0 || y < 0) return 0;
        if (dp[x][y] != null) return dp[x][y];
        return dp[x][y] = memoization(dp, x - 1, y) + memoization(dp, x, y - 1);
    }
}
