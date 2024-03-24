package BaekJoon.Solve2024.March.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem1743 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int height = Integer.parseInt(st.nextToken());
        int width = Integer.parseInt(st.nextToken());
        int trashCnt = Integer.parseInt(st.nextToken());

        int[][] field = new int[height][width];
        for (int i = 0; i < trashCnt; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            field[x][y] = 1;
        }

        int res = 0;
        int[] dx = { -1, 0, 1, 0 };
        int[] dy = { 0, 1, 0, -1 };
        boolean[][] isCounted = new boolean[height][width];
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (!isCounted[i][j] && field[i][j] == 1) {
                    q.offer(new int[]{ i, j });
                    isCounted[i][j] = true;

                    int size = 0;
                    while (!q.isEmpty()) {
                        int[] now = q.poll();
                        size++;

                        for (int k = 0; k < 4; k++) {
                            int nx = now[0] + dx[k];
                            int ny = now[1] + dy[k];
                            if (nx < 0 || nx >= height || ny < 0 || ny >= width || isCounted[nx][ny] || field[nx][ny] == 0) continue;
                            isCounted[nx][ny] = true;
                            q.offer(new int[]{ nx, ny });
                        }
                    }
                    res = Math.max(res, size);
                }
            }
        }
        System.out.print(res);

        br.close();
    }
}
