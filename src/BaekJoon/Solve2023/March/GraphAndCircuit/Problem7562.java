package BaekJoon.Solve2023.March.GraphAndCircuit;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem7562 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int caseCnt = Integer.parseInt(br.readLine());
        for (int i = 0; i < caseCnt; i++) {
            int size = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            Point from = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), 0);
            st = new StringTokenizer(br.readLine());
            Point to = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), 0);

            Queue<Point> que = new LinkedList<>();
            boolean[][] visited = new boolean[size][size];
            if (isPossible(from.x + 1, from.y + 2, size)) {
                que.add(new Point(from.x + 1, from.y + 2, 1));
                visited[from.x + 1][from.y + 2] = true;
            }
            if (isPossible(from.x + 2, from.y + 1, size)) {
                que.add(new Point(from.x + 2, from.y + 1, 1));
                visited[from.x + 2][from.y + 1] = true;
            }
            if (isPossible(from.x + 2, from.y - 1, size)) {
                que.add(new Point(from.x + 2, from.y - 1, 1));
                visited[from.x + 2][from.y - 1] = true;
            }
            if (isPossible(from.x + 1, from.y - 2, size)) {
                que.add(new Point(from.x + 1, from.y - 2, 1));
                visited[from.x + 1][from.y - 2] = true;
            }
            if (isPossible(from.x - 1, from.y - 2, size)) {
                que.add(new Point(from.x - 1, from.y - 2, 1));
                visited[from.x - 1][from.y - 2] = true;
            }
            if (isPossible(from.x - 2, from.y - 1, size)) {
                que.add(new Point(from.x - 2, from.y - 1, 1));
                visited[from.x - 2][from.y - 1] = true;
            }
            if (isPossible(from.x - 2, from.y + 1, size)) {
                que.add(new Point(from.x - 2, from.y + 1, 1));
                visited[from.x - 2][from.y + 1] = true;
            }
            if (isPossible(from.x - 1, from.y + 2, size)) {
                que.add(new Point(from.x - 1, from.y + 2, 1));
                visited[from.x - 1][from.y + 2] = true;
            }

            if (from.x == to.x && from.y == to.y) {
                bw.write("0");
                bw.newLine();
                que.clear();
            }
            while (!que.isEmpty()) {
                Point tmp = que.poll();

                if (tmp.x == to.x && tmp.y == to.y) {
                    bw.write(String.valueOf(tmp.ord));
                    bw.newLine();
                    que.clear();
                    break;
                }

                if (isPossible(tmp.x + 1, tmp.y + 2, size) && !visited[tmp.x + 1][tmp.y + 2]) {
                    que.add(new Point(tmp.x + 1, tmp.y + 2, tmp.ord + 1));
                    visited[tmp.x + 1][tmp.y + 2] = true;
                }
                if (isPossible(tmp.x + 2, tmp.y + 1, size) && !visited[tmp.x + 2][tmp.y + 1]) {
                    que.add(new Point(tmp.x + 2, tmp.y + 1, tmp.ord + 1));
                    visited[tmp.x + 2][tmp.y + 1] = true;
                }
                if (isPossible(tmp.x + 2, tmp.y - 1, size) && !visited[tmp.x + 2][tmp.y - 1]) {
                    que.add(new Point(tmp.x + 2, tmp.y - 1, tmp.ord + 1));
                    visited[tmp.x + 2][tmp.y - 1] = true;
                }
                if (isPossible(tmp.x + 1, tmp.y - 2, size) && !visited[tmp.x + 1][tmp.y - 2]) {
                    que.add(new Point(tmp.x + 1, tmp.y - 2, tmp.ord + 1));
                    visited[tmp.x + 1][tmp.y - 2] = true;
                }
                if (isPossible(tmp.x - 1, tmp.y - 2, size) && !visited[tmp.x - 1][tmp.y - 2]) {
                    que.add(new Point(tmp.x - 1, tmp.y - 2, tmp.ord + 1));
                    visited[tmp.x - 1][tmp.y - 2] = true;
                }
                if (isPossible(tmp.x - 2, tmp.y - 1, size) && !visited[tmp.x - 2][tmp.y - 1]) {
                    que.add(new Point(tmp.x - 2, tmp.y - 1, tmp.ord + 1));
                    visited[tmp.x - 2][tmp.y - 1] = true;
                }
                if (isPossible(tmp.x - 2, tmp.y + 1, size) && !visited[tmp.x - 2][tmp.y + 1]) {
                    que.add(new Point(tmp.x - 2, tmp.y + 1, tmp.ord + 1));
                    visited[tmp.x - 2][tmp.y + 1] = true;
                }
                if (isPossible(tmp.x - 1, tmp.y + 2, size) && !visited[tmp.x - 1][tmp.y + 2]) {
                    que.add(new Point(tmp.x - 1, tmp.y + 2, tmp.ord + 1));
                    visited[tmp.x - 1][tmp.y + 2] = true;
                }
            }
        }

        br.close();
        bw.close();
    }

    private boolean isPossible(int x, int y, int size) {
        if (x < 0 || y < 0 || x > size - 1 || y > size -1) {
            return false;
        }

        return true;
    }

    class Point {
        int x;
        int y;
        int ord;

        public Point(int x_, int y_, int ord_) {
            this.x = x_;
            this.y = y_;
            this.ord = ord_;
        }
    }
}
