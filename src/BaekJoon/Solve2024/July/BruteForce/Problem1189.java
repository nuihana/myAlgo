package BaekJoon.Solve2024.July.BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem1189 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int row = Integer.parseInt(st.nextToken());
        int col = Integer.parseInt(st.nextToken());
        int dist = Integer.parseInt(st.nextToken());

        char[][] map = new char[row][col];
        for (int i = 0; i < row; i++) {
            String line = br.readLine();
            for (int j = 0; j < col; j++) {
                map[i][j] = line.charAt(j);
            }
        }

        boolean[][] isVisit = new boolean[row][col];
        isVisit[row - 1][0] = true;
        System.out.print(dfs(map, isVisit, row - 1, 0, 1, dist));

        br.close();
    }

    private int dfs(char[][] map, boolean[][] isVisit, int i, int j, int dist, int limit) {
        if (dist > limit || map[i][j] == 'T') return 0;
        if (dist == limit && i == 0 && j == map[0].length - 1) {
            return 1;
        }

        int[] dx = { -1, 0, 1, 0 };
        int[] dy = { 0, 1, 0, -1 };
        int res = 0;
        for (int k = 0; k < 4; k++) {
            int nx = i + dx[k];
            int ny = j + dy[k];

            if (nx < 0 || nx >= map.length || ny < 0 || ny >= map[0].length || map[nx][ny] == 'T' || isVisit[nx][ny]) continue;
            isVisit[nx][ny] = true;
            res += dfs(map, isVisit, nx, ny, dist + 1, limit);
            isVisit[nx][ny] = false;
        }

        return res;
    }
}
