package BaekJoon.Solve2024.December.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem14430 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int height = Integer.parseInt(st.nextToken());
        int width = Integer.parseInt(st.nextToken());

        int[][] field = new int[height][width];
        for (int i = 0; i < height; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < width; j++) {
                field[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Integer[][] dp = new Integer[height][width];
        System.out.print(memoization(field, dp, 0, 0));

        br.close();
    }

    private int memoization(int[][] field, Integer[][] dp, int x, int y) {
        if (x >= dp.length || y >= dp[x].length) return 0;
        if (dp[x][y] != null) return dp[x][y];
        return dp[x][y] = Math.max(memoization(field, dp, x + 1, y), memoization(field, dp, x, y + 1)) + field[x][y];
    }
}
