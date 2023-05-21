package BaekJoon.Solve2023.May.Random;

import java.io.*;
import java.util.*;

public class Problem14502 {
    int height;
    int width;
    int[][] room;
    List<Point> virusList;
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        height = Integer.parseInt(st.nextToken());
        width = Integer.parseInt(st.nextToken());
        room = new int[height][width];

        virusList = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < width; j++) {
                room[i][j] = Integer.parseInt(st.nextToken());

                if (room[i][j] == 2) {
                    virusList.add(new Point(i, j));
                }
            }
        }

        bw.write(String.valueOf(getMaximumSafety(0)));

        br.close();
        bw.close();
    }

    private int getMaximumSafety(int depth) {
        if (depth == 3) {
            return getSafety();
        }

        int max = 0;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (room[i][j] == 0) {
                    room[i][j] = 1;
                    max = Math.max(max, getMaximumSafety(depth + 1));
                    room[i][j] = 0;
                }
            }
        }

        return max;
    }
    private int getSafety() {
        Queue<Point> que = new LinkedList<>();
        int[][] tmpRoom = new int[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (room[i][j] == 1) {
                    tmpRoom[i][j] = room[i][j];
                }
            }
        }
        Point start = virusList.isEmpty() ? new Point(0, 0) : virusList.get(0);
        que.offer(start);
        if (!virusList.isEmpty()) {
            tmpRoom[start.x][start.y] = 2;
        }

        while(!que.isEmpty()) {
            Point p = que.poll();

            if (p.x > 0 && tmpRoom[p.x - 1][p.y] == 0) {
                tmpRoom[p.x - 1][p.y] = 2;
                que.offer(new Point(p.x - 1, p.y));
            }

            if (p.y < width - 1 && tmpRoom[p.x][p.y + 1] == 0) {
                tmpRoom[p.x][p.y + 1] = 2;
                que.offer(new Point(p.x, p.y + 1));
            }

            if (p.x < height - 1 && tmpRoom[p.x + 1][p.y] == 0) {
                tmpRoom[p.x + 1][p.y] = 2;
                que.offer(new Point(p.x + 1, p.y));
            }

            if (p.y > 0 && tmpRoom[p.x][p.y - 1] == 0) {
                tmpRoom[p.x][p.y - 1] = 2;
                que.offer(new Point(p.x, p.y - 1));
            }

            if (que.isEmpty()) {
                if (!virusList.isEmpty()) {
                    for (Point vp : virusList) {
                        if (tmpRoom[vp.x][vp.y] == 0) {
                            que.offer(vp);
                            tmpRoom[vp.x][vp.y] = 2;
                            break;
                        }
                    }
                }
            }
        }

        int result = 0;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (tmpRoom[i][j] == 0) {
                    result++;
                }
            }
        }

        return result;
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
