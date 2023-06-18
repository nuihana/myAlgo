package BaekJoon.Solve2023.June.Random;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem21736 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int height = Integer.parseInt(st.nextToken());
        int width = Integer.parseInt(st.nextToken());

        int[][] field = new int[height][width];
        Point start = null;
        for (int i = 0; i < height; i++) {
            String line = br.readLine();
            for (int j = 0; j < width; j++) {
                char c = line.charAt(j);

                if (c == 'O') {
                    field[i][j] = 0;
                } else if (c == 'X') {
                    field[i][j] = -1;
                } else if (c == 'P') {
                    field[i][j] = 1;
                } else if (c == 'I') {
                    field[i][j] = 0;
                    start = new Point(i, j);
                }
            }
        }

        Queue<Point> que = new LinkedList<>();
        boolean[][] visited = new boolean[height][width];
        que.offer(start);
        visited[start.x][start.y] = true;
        int result = 0;
        while(!que.isEmpty()) {
            Point now = que.poll();

            if (now.x > 0 && !visited[now.x - 1][now.y] && field[now.x - 1][now.y] != -1) {
                if (field[now.x - 1][now.y] == 1) {
                    result++;
                }
                visited[now.x - 1][now.y] = true;
                que.offer(new Point(now.x - 1, now.y));
            }

            if (now.y < width - 1 && !visited[now.x][now.y + 1] && field[now.x][now.y + 1] != -1) {
                if (field[now.x][now.y + 1] == 1) {
                    result++;
                }
                visited[now.x][now.y + 1] = true;
                que.offer(new Point(now.x, now.y + 1));
            }

            if (now.x < height - 1 && !visited[now.x + 1][now.y] && field[now.x + 1][now.y] != -1) {
                if (field[now.x + 1][now.y] == 1) {
                    result++;
                }
                visited[now.x + 1][now.y] = true;
                que.offer(new Point(now.x + 1, now.y));
            }

            if (now.y > 0 && !visited[now.x][now.y - 1] && field[now.x][now.y - 1] != -1) {
                if (field[now.x][now.y - 1] == 1) {
                    result++;
                }
                visited[now.x][now.y - 1] = true;
                que.offer(new Point(now.x, now.y - 1));
            }
        }

        if (result == 0) {
            bw.write("TT");
        } else {
            bw.write(String.valueOf(result));
        }

        br.close();
        bw.close();
    }

    class Point {
        int x;
        int y;

        public Point(int x_, int y_) {
            this.x = x_;
            this.y = y_;
        }
    }
}
