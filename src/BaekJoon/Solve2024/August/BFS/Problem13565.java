package BaekJoon.Solve2024.August.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem13565 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int height = Integer.parseInt(st.nextToken());
        int width = Integer.parseInt(st.nextToken());

        Queue<int[]> q = new LinkedList<>();
        boolean[][] isVisit = new boolean[height][width];
        char[][] map = new char[height][width];
        for (int i = 0; i < height; i++) {
            String line = br.readLine();
            for (int j = 0; j < width; j++) {
                map[i][j] = line.charAt(j);
                if (map[i][j] == '0' && i == 0) {
                    q.offer(new int[]{ i, j });
                    isVisit[i][j] = true;
                }
            }
        }

        int[] dx = { -1, 0, 1, 0 };
        int[] dy = { 0, 1, 0, -1 };
        boolean pass = false;
        while (!q.isEmpty()) {
            int[] now = q.poll();

            if (now[0] == height - 1) {
                pass = true;
                break;
            }

            for (int i = 0; i < 4; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];

                if (nx < 0 || nx >= height || ny < 0 || ny >= width || map[nx][ny] == '1' || isVisit[nx][ny]) continue;
                isVisit[nx][ny] = true;
                q.offer(new int[]{ nx, ny });
            }
        }

        if (pass) System.out.print("YES");
        else System.out.print("NO");

        br.close();
    }
}
