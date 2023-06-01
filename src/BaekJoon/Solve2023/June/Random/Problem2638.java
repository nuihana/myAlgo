package BaekJoon.Solve2023.June.Random;

import java.io.*;
import java.util.*;

public class Problem2638 {
    int height;
    int width;
    int[][] paper;
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        height = Integer.parseInt(st.nextToken());
        width = Integer.parseInt(st.nextToken());

        paper = new int[height][width];
        Queue<Point> cheese = new LinkedList<>();
        for (int i = 0; i < height; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < width; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());

                if (paper[i][j] == 1) {
                    cheese.offer(new Point(i, j, 0));
                }
            }
        }

        dfs(0, 0);

        Queue<Point> meltCheese = new LinkedList<>();
        Queue<Point> nextCheese = new LinkedList<>();
        int turn = 0;
        while(!cheese.isEmpty()) {
            turn++;
            while(!cheese.isEmpty()) {
                Point p = cheese.poll();

                if (surroundAir(p) < 2) {
                    nextCheese.offer(p);
                } else {
                    meltCheese.offer(p);
                }
            }

            while(!meltCheese.isEmpty()) {
                Point p = meltCheese.poll();

                paper[p.x][p.y] = 0;
                dfs(p.x, p.y);
            }

            while (!nextCheese.isEmpty()) {
                cheese.offer(nextCheese.poll());
            }
        }

        bw.write(String.valueOf(turn));

        br.close();
        bw.close();
    }

    private void dfs(int x, int y) {
        if (paper[x][y] != 0) return;
        paper[x][y] = 2;

        if (x > 0) {
            dfs(x - 1, y);
        }

        if (y < width - 1) {
            dfs(x, y + 1);
        }

        if (x < height - 1) {
            dfs(x + 1, y);
        }

        if (y > 0) {
            dfs(x, y - 1);
        }
    }
    private int surroundAir(Point p) {
        int result = 0;

        if (p.x > 0) {
            if (paper[p.x - 1][p.y] == 2) result++;
        }

        if (p.y < width - 1) {
            if (paper[p.x][p.y + 1] == 2) result++;
        }

        if (p.x < height - 1) {
            if (paper[p.x + 1][p.y] == 2) result++;
        }

        if (p.y > 0) {
            if (paper[p.x][p.y - 1] == 2) result++;
        }

        return result;
    }

    class Point {
        int x;
        int y;
        int time;

        public Point(int x_, int y_) {
            this.x = x_;
            this.y = y_;
        }
        public Point(int x_, int y_, int time_) {
            this.x = x_;
            this.y = y_;
            this.time = time_;
        }
    }
}
