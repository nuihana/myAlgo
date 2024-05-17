package BaekJoon.Solve2024.May.DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Problem2210 {
    int[][] map = new int[5][5];
    Set<Integer> res = new HashSet<>();
    int[] dx = { -1, 0, 1, 0 };
    int[] dy = { 0, 1, 0, -1 };

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                dfs(i, j, 0, 0);
            }
        }

        System.out.print(res.size());

        br.close();
    }

    private void dfs(int x, int y, int val, int depth) {
        if (depth == 6) {
            res.add(val);
            return;
        }

        val = val * 10 + map[x][y];

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || nx >= 5 || ny < 0 || ny >= 5) continue;
            dfs(nx, ny, val, depth + 1);
        }
    }
}
