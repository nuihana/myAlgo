package BaekJoon.Solve2023.June.Random;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem14940 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int height = Integer.parseInt(st.nextToken());
        int width = Integer.parseInt(st.nextToken());

        int[][] field = new int[height][width];
        Point start = null;
        for (int i = 0; i < height; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < width; j++) {
                int status = Integer.parseInt(st.nextToken());

                if (status == 2) {
                    start = new Point(i, j);
                }

                if (status == 0) {
                    field[i][j] = -2;
                } else {
                    field[i][j] = -1;
                }
            }
        }

        Queue<Point> que = new LinkedList<>();
        que.offer(start);
        field[start.x][start.y] = 0;
        while(!que.isEmpty()) {
            Point now = que.poll();

            if (now.x > 0 && field[now.x - 1][now.y] == -1) {
                field[now.x - 1][now.y] = now.turn + 1;
                que.offer(new Point(now.x - 1, now.y, now.turn + 1));
            }

            if (now.y < width - 1 && field[now.x][now.y + 1] == -1) {
                field[now.x][now.y + 1] = now.turn + 1;
                que.offer(new Point(now.x, now.y + 1, now.turn + 1));
            }

            if (now.x < height - 1 && field[now.x + 1][now.y] == -1) {
                field[now.x + 1][now.y] = now.turn + 1;
                que.offer(new Point(now.x + 1, now.y, now.turn + 1));
            }

            if (now.y > 0 && field[now.x][now.y - 1] == -1) {
                field[now.x][now.y - 1] = now.turn + 1;
                que.offer(new Point(now.x, now.y - 1, now.turn + 1));
            }
        }

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (field[i][j] == -2) field[i][j] = 0;
                bw.write(field[i][j] + " ");
            }
            bw.newLine();
        }

        br.close();
        bw.close();
    }

    class Point {
        int x;
        int y;
        int turn;

        public Point(int x_, int y_) {
            this.x = x_;
            this.y = y_;
            this.turn = 0;
        }
        public Point(int x_, int y_, int turn_) {
            this.x = x_;
            this.y = y_;
            this.turn = turn_;
        }
    }
}
