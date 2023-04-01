package BaekJoon.Solve2023.March.GraphAndCircuit;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem2178 {
    int[][] field;
    int[][] visited;
    int height;
    int width;
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        height = Integer.parseInt(st.nextToken());
        width = Integer.parseInt(st.nextToken());

        field = new int[width][height];
        visited = new int[width][height];

        for (int i = 0; i < height; i++) {
            String tmp = br.readLine();
            for (int j = 0; j < width; j++) {
                field[j][i] = Integer.parseInt(tmp.substring(j, j + 1));
            }
        }

        findPath();

        bw.write(String.valueOf(visited[width - 1][height - 1]));

        br.close();
        bw.close();
    }

    private void findPath() {
        visited[0][0] = 1;

        Queue<Point> que = new LinkedList<>();
        if (field[1][0] == 1) {
            que.add(new Point(1, 0, 2));
            visited[1][0] = 2;
        }
        if (field[0][1] == 1) {
            que.add(new Point(0, 1, 2));
            visited[0][1] = 2;
        }

        while (!que.isEmpty()) {
            Point tmp = que.poll();

            if (tmp.y > 0 && field[tmp.x][tmp.y - 1] == 1 && visited[tmp.x][tmp.y - 1] == 0) {
                que.add(new Point(tmp.x, tmp.y - 1, tmp.ord + 1));
                visited[tmp.x][tmp.y - 1] = tmp.ord + 1;
            }

            if (tmp.x < width - 1 && field[tmp.x + 1][tmp.y] == 1 && visited[tmp.x + 1][tmp.y] == 0) {
                que.add(new Point(tmp.x + 1, tmp.y, tmp.ord + 1));
                visited[tmp.x + 1][tmp.y] = tmp.ord + 1;
            }

            if (tmp.y < height - 1 && field[tmp.x][tmp.y + 1] == 1 && visited[tmp.x][tmp.y + 1] == 0) {
                que.add(new Point(tmp.x, tmp.y + 1, tmp.ord + 1));
                visited[tmp.x][tmp.y + 1] = tmp.ord + 1;
            }

            if (tmp.x > 0 && field[tmp.x - 1][tmp.y] == 1 && visited[tmp.x - 1][tmp.y] == 0) {
                que.add(new Point(tmp.x - 1, tmp.y, tmp.ord + 1));
                visited[tmp.x - 1][tmp.y] = tmp.ord + 1;
            }
        }
    }
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
