package BaekJoon.Solve2023.May.CP_BFS;

import java.io.*;
import java.util.*;

public class Problem1261 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        int[][] maze = new int[m][n];
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                maze[j][i] = Integer.parseInt(line.substring(j, j + 1));
            }
        }

        Integer[][] cost = new Integer[m][n];
        Queue<Point> que = new LinkedList<>();
        que.offer(new Point(0, 0, 0));
        cost[0][0] = 0;

        while(!que.isEmpty()) {
            Point p = que.poll();

            if (p.y > 0 && (cost[p.x][p.y - 1] == null || cost[p.x][p.y - 1] > p.cost + maze[p.x][p.y - 1])) {
                cost[p.x][p.y - 1] = p.cost + maze[p.x][p.y - 1];
                que.offer(new Point(p.x, p.y - 1, p.cost + maze[p.x][p.y - 1]));
            }

            if (p.x < m - 1 && (cost[p.x + 1][p.y] == null || cost[p.x + 1][p.y] > p.cost + maze[p.x + 1][p.y])) {
                cost[p.x + 1][p.y] = p.cost + maze[p.x + 1][p.y];
                que.offer(new Point(p.x + 1, p.y, p.cost + maze[p.x + 1][p.y]));
            }

            if (p.y < n - 1 && (cost[p.x][p.y + 1] == null || cost[p.x][p.y + 1] > p.cost + maze[p.x][p.y + 1])) {
                cost[p.x][p.y + 1] = p.cost + maze[p.x][p.y + 1];
                que.offer(new Point(p.x, p.y + 1, p.cost + maze[p.x][p.y + 1]));
            }

            if (p.x > 0 && (cost[p.x - 1][p.y] == null || cost[p.x - 1][p.y] > p.cost + maze[p.x - 1][p.y])) {
                cost[p.x - 1][p.y] = p.cost + maze[p.x - 1][p.y];
                que.offer(new Point(p.x - 1, p.y, p.cost + maze[p.x - 1][p.y]));
            }
        }

        bw.write(String.valueOf(cost[m - 1][n - 1]));

        br.close();
        bw.close();
    }

    class Point {
        int x;
        int y;
        int cost;

        public Point(int x_, int y_, int cost_) {
            this.x = x_;
            this.y = y_;
            this.cost = cost_;
        }
    }
}
