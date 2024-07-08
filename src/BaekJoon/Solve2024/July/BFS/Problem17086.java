package BaekJoon.Solve2024.July.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Problem17086 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int height = Integer.parseInt(st.nextToken());
        int width = Integer.parseInt(st.nextToken());

        int[][] map = new int[height][width];

        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < height; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < width; j++) {
                int n = Integer.parseInt(st.nextToken());

                if (n == 1) {
                    map[i][j] = -1;
                    q.offer(new int[]{ i, j, 1 });
                }
            }
        }

        int[] dx = { -1, -1, 0, 1, 1, 1, 0, -1 };
        int[] dy = { 0, 1, 1, 1, 0, -1, -1, -1 };
        while (!q.isEmpty()) {
            int[] now = q.poll();

            for (int i = 0; i < 8; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];

                if (nx < 0 || nx >= height || ny < 0 || ny >= width || map[nx][ny] != 0) continue;
                map[nx][ny] = now[2];
                q.offer(new int[]{ nx, ny, now[2] + 1 });
            }
        }

        int res = 0;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                res = Math.max(res, map[i][j]);
            }
        }

        System.out.print(res);

        br.close();
    }
}
