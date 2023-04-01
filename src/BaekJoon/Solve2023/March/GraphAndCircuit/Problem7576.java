package BaekJoon.Solve2023.March.GraphAndCircuit;

import java.io.*;
import java.util.*;

public class Problem7576 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int width = Integer.parseInt(st.nextToken());
        int height = Integer.parseInt(st.nextToken());
        int[][] box = new int[width][height];

        List<Point> startPoints = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < width; j++) {
                box[j][i] = Integer.parseInt(st.nextToken());
                if (box[j][i] == 1) {
                    startPoints.add(new Point(j, i, 1));
                }
            }
        }

        Queue<Point> que = new LinkedList<>(startPoints);
        while (!que.isEmpty()) {
            Point tmp = que.poll();

            if (tmp.y > 0 && box[tmp.x][tmp.y - 1] == 0) {
                box[tmp.x][tmp.y - 1] = tmp.ord + 1;
                que.add(new Point(tmp.x, tmp.y - 1, tmp.ord + 1));
            }

            if (tmp.x < width - 1 && box[tmp.x + 1][tmp.y] == 0) {
                box[tmp.x + 1][tmp.y] = tmp.ord + 1;
                que.add(new Point(tmp.x + 1, tmp.y, tmp.ord + 1));
            }

            if (tmp.y < height - 1 && box[tmp.x][tmp.y + 1] == 0) {
                box[tmp.x][tmp.y + 1] = tmp.ord + 1;
                que.add(new Point(tmp.x, tmp.y + 1, tmp.ord + 1));
            }

            if (tmp.x > 0 && box[tmp.x - 1][tmp.y] == 0) {
                box[tmp.x - 1][tmp.y] = tmp.ord + 1;
                que.add(new Point(tmp.x - 1, tmp.y, tmp.ord + 1));
            }
        }

        boolean noFlag = true;
        int endDate = 0;

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (noFlag) {
                    if (box[j][i] == 0) {
                        noFlag = false;
                    }
                    endDate = Math.max(endDate, box[j][i]);
                } else {
                    break;
                }
            }
            if (!noFlag) {
                break;
            }
        }

        if (noFlag) {
            bw.write(String.valueOf(endDate - 1));
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
