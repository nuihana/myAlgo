package BaekJoon.Solve2023.December.DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem11048 {
    Integer[][] candies, dp;
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int height = Integer.parseInt(st.nextToken());
        int width = Integer.parseInt(st.nextToken());

        candies = new Integer[height][width];
        dp = new Integer[height][width];
        for (int i = 0; i < height; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < width; j++) {
                candies[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.print(memoization(height - 1, width - 1));

        br.close();
    }

    private int memoization(int x, int y) {
        if (dp[x][y] != null) return dp[x][y];

        int result = candies[x][y];
        int add = 0;
        if (x > 0) add = Math.max(add, memoization(x - 1, y));
        if (y > 0) add = Math.max(add, memoization(x, y - 1));
        if (x > 0 && y > 0) add = Math.max(add, memoization(x - 1, y - 1));

        return dp[x][y] = result + add;
    }
}
