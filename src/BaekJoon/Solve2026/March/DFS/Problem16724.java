package BaekJoon.Solve2026.March.DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem16724 {
    int res = 0;
    int[] dx = { 1, 0, 0, -1 };
    int[] dy = { 0, -1, 1, 0 };

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int height = Integer.parseInt(st.nextToken());
        int width = Integer.parseInt(st.nextToken());

        int[][] map = new int[height][width];
        for (int i = 0; i < height; i++) {
            String line = br.readLine();
            for (int j = 0; j < width; j++) {
                int val = -1;
                if (line.charAt(j) == 'D') val = 0;
                else if (line.charAt(j) == 'L') val = 1;
                else if (line.charAt(j) == 'R') val = 2;
                else if (line.charAt(j) == 'U') val = 3;
                map[i][j] = val;
            }
        }

        int[][] visited = new int[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (visited[i][j] == 0) {
                    dfs(i, j, visited, map);
                }
            }
        }
        System.out.print(res);

        br.close();
    }

    private void dfs(int x, int y, int[][] visited, int[][] map) {
        visited[x][y] = 1;

        int nx = x + dx[map[x][y]];
        int ny = y + dy[map[x][y]];

        if (visited[nx][ny] == 0) dfs(nx, ny, visited, map);
        else if (visited[nx][ny] == 1) res++;

        visited[x][y] = 2;
    }
}
