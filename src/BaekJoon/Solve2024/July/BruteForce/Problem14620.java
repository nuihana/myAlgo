package BaekJoon.Solve2024.July.BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem14620 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[][] map = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        boolean[][] isChk = new boolean[n][n];
        System.out.print(dfs(map, isChk, 0));

        br.close();
    }

    private int dfs(int[][] map, boolean[][] isChk, int cnt) {
        if (cnt == 3) return 0;

        int res = 20001;
        int[] dx = { 0, -1, 0, 1, 0 };
        int[] dy = { 0, 0, 1, 0, -1 };
        for (int i = 1; i < map.length - 1; i++) {
            for (int j = 1; j < map[0].length - 1; j++) {
                // 영역 체크
                boolean isImpossible = false;
                for (int k = 0; k < 5; k++) {
                    int nx = i + dx[k];
                    int ny = j + dy[k];

                    if (isChk[nx][ny]) {
                        isImpossible = true;
                        break;
                    }
                }

                if (isImpossible) continue;

                int next = 0;
                for (int k = 0; k < 5; k++) {
                    int nx = i + dx[k];
                    int ny = j + dy[k];

                    isChk[nx][ny] = true;
                    next += map[nx][ny];
                }

                res = Math.min(res, next + dfs(map, isChk, cnt + 1));

                for (int k = 0; k < 5; k++) {
                    int nx = i + dx[k];
                    int ny = j + dy[k];

                    isChk[nx][ny] = false;
                }
            }
        }
        return res;
    }
}
