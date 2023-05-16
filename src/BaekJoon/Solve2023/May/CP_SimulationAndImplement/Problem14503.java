package BaekJoon.Solve2023.May.CP_SimulationAndImplement;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem14503 {
    int height;
    int width;
    int[][] field;
    boolean[][] cleaned;
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        height = Integer.parseInt(st.nextToken());
        width = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int startX = Integer.parseInt(st.nextToken());
        int startY = Integer.parseInt(st.nextToken());
        int startDirection = Integer.parseInt(st.nextToken()); // 0 : 북, 1: 동, 2: 남, 3: 서

        field = new int[height][width];
        for (int i = 0; i < height; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < width; j++) {
                field[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Queue<Point> que = new LinkedList<>();
        cleaned = new boolean[height][width];
        que.offer(new Point(startX, startY));
        int result = 0;

        while(!que.isEmpty()) {
            Point p = que.poll();

            if (field[p.x][p.y] == 0 && !cleaned[p.x][p.y]) { // 청소
                cleaned[p.x][p.y] = true;
                que.offer(new Point(p.x, p.y));
                result++;
                continue;
            }

            if (chkDirty(p)) { // 주변에 청소 되지 않은 빈 칸 x
                if (startDirection == 0) {
                    if (p.x + 1 == height) { // 남쪽 끝임
                        break;
                    }

                    if (field[p.x + 1][p.y] == 0) { //청소된 빈 공간임
                        que.offer(new Point(p.x + 1, p.y));
                    }
                } else if (startDirection == 1) {
                    if (p.y == 0) {
                        break;
                    }

                    if (field[p.x][p.y - 1] == 0) { //청소된 빈 공간임
                        que.offer(new Point(p.x, p.y - 1));
                    }
                } else if (startDirection == 2) {
                    if (p.x == 0) {
                        break;
                    }

                    if (field[p.x - 1][p.y] == 0) { //청소된 빈 공간임
                        que.offer(new Point(p.x - 1, p.y));
                    }
                } else if (startDirection == 3) {
                    if (p.y + 1 == width) {
                        break;
                    }

                    if (field[p.x][p.y + 1] == 0) { //청소된 빈 공간임
                        que.offer(new Point(p.x, p.y + 1));
                    }
                }
            } else {
                startDirection = (startDirection + 3) % 4; // 90도 반시계방향 회전

                if (startDirection == 0) {
                    if (p.x > 0 && field[p.x - 1][p.y] == 0 && !cleaned[p.x - 1][p.y]) {
                        que.offer(new Point(p.x - 1, p.y));
                        continue;
                    }
                } else if (startDirection == 1) {
                    if (p.y < width - 1 && field[p.x][p.y + 1] == 0 && !cleaned[p.x][p.y + 1]) {
                        que.offer(new Point(p.x, p.y + 1));
                        continue;
                    }
                } else if (startDirection == 2) {
                    if (p.x < height - 1 && field[p.x + 1][p.y] == 0 && !cleaned[p.x + 1][p.y]) {
                        que.offer(new Point(p.x + 1, p.y));
                        continue;
                    }
                } else if (startDirection == 3) {
                    if (p.y > 0 && field[p.x][p.y - 1] == 0 && !cleaned[p.x][p.y - 1]) {
                        que.offer(new Point(p.x, p.y - 1));
                        continue;
                    }
                }

                que.offer(new Point(p.x, p.y));
            }
        }

        bw.write(String.valueOf(result));

        br.close();
        bw.close();
    }

    private boolean chkDirty(Point p) {
        if (p.x > 0 && field[p.x - 1][p.y] == 0 && !cleaned[p.x - 1][p.y]) {
            return false;
        } else if (p.y < width - 1 && field[p.x][p.y + 1] == 0 && !cleaned[p.x][p.y + 1]) {
            return false;
        } else if (p.x < height - 1 && field[p.x + 1][p.y] == 0 && !cleaned[p.x + 1][p.y]) {
            return false;
        } else if (p.y > 0 && field[p.x][p.y - 1] == 0 && !cleaned[p.x][p.y - 1]) {
            return false;
        }
        return true;
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
