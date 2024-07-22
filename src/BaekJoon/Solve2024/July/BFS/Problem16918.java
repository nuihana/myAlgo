package BaekJoon.Solve2024.July.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem16918 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int height = Integer.parseInt(st.nextToken());
        int width = Integer.parseInt(st.nextToken());
        int limit = Integer.parseInt(st.nextToken());

        Queue<int[]> q = new LinkedList<>();
        char[][] map = new char[height][width];
        for (int i = 0; i < height; i++) {
            String line = br.readLine();
            for (int j = 0; j < width; j++) {
                map[i][j] = line.charAt(j);

                if (map[i][j] == 'O') {
                    q.offer(new int[]{ i, j });
                }
            }
        }

        int time = 1;
        boolean isBom = true;
        int[] dx = { -1, 0, 1, 0 };
        int[] dy = { 0, 1, 0, -1 };
        while (time < limit) {
            if (isBom) {
                for (int i = 0; i < height; i++) {
                    for (int j = 0; j < width; j++) {
                        map[i][j] = 'O';
                    }
                }
            } else {
                while (!q.isEmpty()) {
                    int[] now = q.poll();

                    map[now[0]][now[1]] = '.';
                    for (int i = 0; i < 4; i++) {
                        int nx = now[0] + dx[i];
                        int ny = now[1] + dy[i];

                        if (nx < 0 || nx >= height || ny < 0 || ny >= width) continue;
                        map[nx][ny] = '.';
                    }
                }

                for (int i = 0; i < height; i++) {
                    for (int j = 0; j < width; j++) {
                        if (map[i][j] == 'O') {
                            q.offer(new int[]{ i, j });
                        }
                    }
                }
            }

            isBom = !isBom;
            time++;
        }

        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                sb.append(map[i][j]);
            }
            sb.append("\n");
        }

        System.out.print(sb);

        br.close();
    }
}
