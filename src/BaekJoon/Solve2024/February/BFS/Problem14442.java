package BaekJoon.Solve2024.February.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem14442 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int height = Integer.parseInt(st.nextToken());
        int width = Integer.parseInt(st.nextToken());
        int canBreak = Integer.parseInt(st.nextToken());

        boolean[][][] visit = new boolean[height][width][canBreak + 1];
        int[][] field = new int[height][width];
        for (int i = 0; i < height; i++) {
            String line = br.readLine();
            for (int j = 0; j < width; j++) {
                field[i][j] = line.charAt(j) - '0';
            }
        }

        int res = -1;
        Queue<int[]> q = new LinkedList<>();
        visit[0][0][0] = true;
        q.offer(new int[]{ 0, 0, 0, 1 });
        int[] dx = { -1, 0, 1, 0 };
        int[] dy = { 0, 1, 0, -1 };
        while (!q.isEmpty()) {
            int[] now = q.poll();

            if (now[0] == height - 1 && now[1] == width - 1) {
                res = now[3];
                break;
            }

            for (int i = 0; i < 4; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];
                if (nx < 0 || nx >= height || ny < 0 || ny >= width) continue;

                if (field[nx][ny] == 0 && !visit[nx][ny][now[2]]) {
                    visit[nx][ny][now[2]] = true;
                    q.offer(new int[]{ nx, ny, now[2], now[3] + 1 });
                } else {
                    if (now[2] < canBreak && !visit[nx][ny][now[2] + 1]) {
                        visit[nx][ny][now[2] + 1] = true;
                        q.offer(new int[]{ nx, ny, now[2] + 1, now[3] + 1 });
                    }
                }
            }
        }

        System.out.print(res);

        br.close();
    }
}
