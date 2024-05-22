package BaekJoon.Solve2024.May.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem1303 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int width = Integer.parseInt(st.nextToken());
        int height = Integer.parseInt(st.nextToken());

        char[][] map = new char[height][width];
        for (int i = 0; i < height; i++) {
            String line = br.readLine();
            for (int j = 0; j < width; j++) {
                map[i][j] = line.charAt(j);
            }
        }

        int white = 0;
        int blue = 0;
        int[] dx = { -1, 0, 1, 0 };
        int[] dy = { 0, 1, 0, -1 };
        boolean[][] isCounted = new boolean[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (!isCounted[i][j]) {
                    isCounted[i][j] = true;
                    Queue<int[]> q = new LinkedList<>();
                    q.offer(new int[]{ i, j });
                    int cnt = 0;
                    char team = map[i][j];
                    while (!q.isEmpty()) {
                        int[] now = q.poll();
                        cnt++;
                        for (int k = 0; k < 4; k++) {
                            int nx = now[0] + dx[k];
                            int ny = now[1] + dy[k];
                            if (nx < 0 || nx >= height || ny < 0 || ny >= width || isCounted[nx][ny] || map[nx][ny] != team) continue;
                            isCounted[nx][ny] = true;
                            q.offer(new int[]{ nx, ny });
                        }
                    }

                    if (map[i][j] == 'W') white += cnt * cnt;
                    else blue += cnt * cnt;
                }
            }
        }

        System.out.print(white + " " + blue);

        br.close();
    }
}
