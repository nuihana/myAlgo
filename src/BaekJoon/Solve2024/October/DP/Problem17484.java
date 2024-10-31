package BaekJoon.Solve2024.October.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem17484 {
    private int n, m;
    private int[][] cost;
    private int[][][] mem;
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        cost = new int[n][m];
        mem = new int[n][m][4];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                cost[i][j] = Integer.parseInt(st.nextToken());
                Arrays.fill(mem[i][j], -1);
            }
        }

        int res = Integer.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            res = Math.min(res, memoization(0, i, 1));
            res = Math.min(res, memoization(0, i, 2));
            res = Math.min(res, memoization(0, i, 3));
        }
        System.out.print(res);

        br.close();
    }

    private int memoization(int r, int c, int dir) {
        if (r == n - 1) {
            return cost[r][c];
        }

        if (mem[r][c][dir] != -1) return mem[r][c][dir];

        int res = Integer.MAX_VALUE;
        if (dir == 1) {
            res = Math.min(res, memoization(r + 1, c, 2) + cost[r][c]);
            if (c + 1 < m) {
                res = Math.min(res, memoization(r + 1, c + 1, 3) + cost[r][c]);
            }
        }
        if (dir == 2) {
            if (c > 0) {
                res = Math.min(res, memoization(r + 1, c - 1, 1) + cost[r][c]);
            }
            if (c + 1 < m) {
                res = Math.min(res, memoization(r + 1, c + 1, 3) + cost[r][c]);
            }
        }
        if (dir == 3) {
            if (c > 0) {
                res = Math.min(res, memoization(r + 1, c - 1, 1) + cost[r][c]);
            }
            res = Math.min(res, memoization(r + 1, c, 2) + cost[r][c]);
        }
        return mem[r][c][dir] = res;
    }
}
