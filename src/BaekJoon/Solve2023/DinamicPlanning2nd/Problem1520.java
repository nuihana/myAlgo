package BaekJoon.Solve2023.DinamicPlanning2nd;

import java.io.*;
import java.util.*;

public class Problem1520 {
    int[][] jduMap;
    Integer[][] dp;
    int height;
    int width;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        height = Integer.parseInt(st.nextToken());
        width = Integer.parseInt(st.nextToken());
        jduMap = new int[height][width];
        dp = new Integer[height][width];

        for (int i = 0; i < height; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < width; j++) {
                jduMap[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        bw.write(getPossiblePath(height - 1, width - 1));

        br.close();
        bw.close();
    }

    private int getPossiblePath(int x, int y) {
        if (dp[x][y] != null) {
            return dp[x][y];
        }

        if (x ==0 && y == 0) {
            return 1;
        }

        int pathCnt = 0;
        if (x > 0 && jduMap[x][y] < jduMap[x - 1][y]) {
            pathCnt += getPossiblePath(x - 1, y);
        }
        if (y > 0 && jduMap[x][y] < jduMap[x][y - 1]) {
            pathCnt += getPossiblePath(x, y - 1);
        }
        if (x < height - 1 && jduMap[x][y] < jduMap[x + 1][y]) {
            pathCnt += getPossiblePath(x + 1, y);
        }
        if (y < width - 1 && jduMap[x][y] < jduMap[x][y + 1]) {
            pathCnt += getPossiblePath(x, y + 1);
        }

        return dp[x][y] = pathCnt;
    }
}
