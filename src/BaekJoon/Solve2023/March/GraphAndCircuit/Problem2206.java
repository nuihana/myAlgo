package BaekJoon.Solve2023.March.GraphAndCircuit;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem2206 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int height = Integer.parseInt(st.nextToken());
        int width = Integer.parseInt(st.nextToken());
        int[][] field = new int[width][height];

        for (int i = 0; i < height; i++) {
            String line = br.readLine();
            for (int j = 0; j < width; j++) {
                field[j][i] = Integer.parseInt(line.substring(j, j + 1));
            }
        }

        Queue<Point> que = new LinkedList<>();
        que.add(new Point(0, 0, 1));
        field[0][0] = 1;
        Queue<Point> crashable = new LinkedList<>();
        boolean crashed = false;
        int[][] storedField = null;

        while(!que.isEmpty()) {
            Point tmp = que.poll();

            if (tmp.y > 0) {
                if (field[tmp.x][tmp.y - 1] == 0 || field[tmp.x][tmp.y - 1] > tmp.ord + 1) {
                    field[tmp.x][tmp.y - 1] = tmp.ord + 1;
                    que.add(new Point(tmp.x, tmp.y - 1, tmp.ord + 1));
                } else if (field[tmp.x][tmp.y - 1] == 1 && !crashed) {
                    crashable.add(new Point(tmp.x, tmp.y - 1, tmp.ord + 1));
                }
            }

            if (tmp.x < width - 1) {
                if (field[tmp.x + 1][tmp.y] == 0 || field[tmp.x + 1][tmp.y] > tmp.ord + 1) {
                    field[tmp.x + 1][tmp.y] = tmp.ord + 1;
                    que.add(new Point(tmp.x + 1, tmp.y, tmp.ord + 1));
                } else if (field[tmp.x + 1][tmp.y] == 1 && !crashed) {
                    crashable.add(new Point(tmp.x + 1, tmp.y, tmp.ord + 1));
                }
            }

            if (tmp.y < height - 1) {
                if (field[tmp.x][tmp.y + 1] == 0 || field[tmp.x][tmp.y + 1] > tmp.ord + 1) {
                    field[tmp.x][tmp.y + 1] = tmp.ord + 1;
                    que.add(new Point(tmp.x, tmp.y + 1, tmp.ord + 1));
                } else if (field[tmp.x][tmp.y + 1] == 1 && !crashed) {
                    crashable.add(new Point(tmp.x, tmp.y + 1, tmp.ord + 1));
                }
            }

            if (tmp.x > 0) {
                if (field[tmp.x - 1][tmp.y] == 0 || field[tmp.x - 1][tmp.y] > tmp.ord + 1) {
                    field[tmp.x - 1][tmp.y] = tmp.ord + 1;
                    que.add(new Point(tmp.x - 1, tmp.y, tmp.ord + 1));
                } else if (field[tmp.x - 1][tmp.y] == 1 && !crashed) {
                    crashable.add(new Point(tmp.x - 1, tmp.y, tmp.ord + 1));
                }
            }

            if (que.isEmpty() && !crashable.isEmpty()) {
                if (!crashed) {
                    storedField = field.clone();
                }
                que.add(crashable.poll());
                field = storedField.clone();
                crashed = true;
            }
        }

        if (field[width - 1][height - 1] > 0) {
            bw.write(String.valueOf(field[width - 1][height - 1]));
        } else {
            bw.write("-1");
        }

        br.close();
        bw.close();
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
