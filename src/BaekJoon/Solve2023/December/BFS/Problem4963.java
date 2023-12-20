package BaekJoon.Solve2023.December.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem4963 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());

            if (w == 0 || h == 0) break;
            int[][] field = new int[h][w];
            for (int i = 0; i < h; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < w; j++) {
                    field[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int result = 0;
            boolean[][] isVisited = new boolean[h][w];
            int[] dx = { -1, -1, 0, 1, 1, 1, 0, -1 };
            int[] dy = { 0, 1, 1, 1, 0, -1, -1, -1 };
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (field[i][j] == 1 && !isVisited[i][j]) {
                        result++;
                        isVisited[i][j] = true;
                        Queue<int[]> que = new LinkedList<>();
                        que.offer(new int[]{ i, j });
                        while (!que.isEmpty()) {
                            int[] now = que.poll();
                            for (int k = 0; k < 8; k++) {
                                int nx = now[0] + dx[k];
                                int ny = now[1] + dy[k];
                                if (nx < 0 || nx >= h || ny < 0 || ny >= w || isVisited[nx][ny] || field[nx][ny] == 0) continue;
                                isVisited[nx][ny] = true;
                                que.offer(new int[]{ nx, ny });
                            }
                        }
                    }
                }
            }

            System.out.println(result);
        }

        br.close();
    }
}
