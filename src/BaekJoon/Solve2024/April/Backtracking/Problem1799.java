package BaekJoon.Solve2024.April.Backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem1799 {
    int size;
    int[][] field, bw;
    boolean[][] visited;
    int[] dx = { 1, -1, -1, 1 };
    int[] dy = { 1, 1, -1, -1 };
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        size = Integer.parseInt(br.readLine());
        field = new int[size][size];
        bw = new int[size][size];
        visited = new boolean[size][size];
        for (int i = 0; i < size; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < size; j++) {
                bw[i][j] = (i + j) % 2;
                field[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int black = dfs(0, 0, 0, 0);
        int white = dfs(0, 1, 1, 0);

        System.out.print(black + white);

        br.close();
    }

    private int dfs(int x, int y, int color, int cnt) {
        if (x >= size) {
            return cnt;
        }

        int nx = x;
        int ny = y + 2;

        if (ny >= size) {
            nx++;
            if (nx < size) {
                if (bw[nx][0] == color) ny = 0;
                else ny = 1;
            }
        }

        if (field[x][y] == 0) {
            return dfs(nx, ny, color, cnt);
        }

        int res = cnt;
        if (possible(x, y)) {
            visited[x][y] = true;
            res = Math.max(res, dfs(nx, ny, color, cnt + 1));
            visited[x][y] = false;
        }

        return Math.max(res, dfs(nx, ny, color, cnt));
    }

    private boolean possible(int x, int y) {
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            while (nx >= 0 && nx < size && ny >= 0 && ny < size) {
                if (visited[nx][ny]) return false;
                nx += dx[i];
                ny += dy[i];
            }
        }
        return true;
    }
}
