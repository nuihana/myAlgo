package BaekJoon.Solve2023.March.GraphAndCircuit;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem1012 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int testCase = Integer.parseInt(br.readLine());
        for (int x = 0; x < testCase; x++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int width = Integer.parseInt(st.nextToken());
            int height = Integer.parseInt(st.nextToken());
            int thingCnt = Integer.parseInt(st.nextToken());

            int[][] field = new int[width][height];
            boolean[][] visited = new boolean[width][height];

            for (int i = 0; i < thingCnt; i++) {
                st = new StringTokenizer(br.readLine());
                field[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 1;
            }

            bw.write(String.valueOf(getGroupedArea(field, visited)));
            bw.newLine();
        }

        br.close();
        bw.close();
    }

    private int getGroupedArea(int[][] field_, boolean[][] visited_) {
        int result = 0;
        int fieldWidth = field_.length;
        int fieldHeight = field_[0].length;

        for (int i = 0; i < fieldWidth; i++) {
            for (int j = 0; j < fieldHeight; j++) {
                if (field_[i][j] == 1 && !visited_[i][j]) {
                    result++;
                    visited_[i][j] = true;

                    Queue<Point> que = new LinkedList<>();
                    que.add(new Point(i, j));
                    while (!que.isEmpty()) {
                        Point tmp = que.poll();

                        if (tmp.x > 0 && !visited_[tmp.x - 1][tmp.y] && field_[tmp.x - 1][tmp.y] == 1) {
                            visited_[tmp.x - 1][tmp.y] = true;
                            que.add(new Point(tmp.x - 1, tmp.y));
                        }

                        if (tmp.y < fieldHeight - 1 && !visited_[tmp.x][tmp.y + 1] && field_[tmp.x][tmp.y + 1] == 1) {
                            visited_[tmp.x][tmp.y + 1] = true;
                            que.add(new Point(tmp.x, tmp.y + 1));
                        }

                        if (tmp.x < fieldWidth - 1 && !visited_[tmp.x + 1][tmp.y] && field_[tmp.x + 1][tmp.y] == 1) {
                            visited_[tmp.x + 1][tmp.y] = true;
                            que.add(new Point(tmp.x + 1, tmp.y));
                        }

                        if (tmp.y > 0 && !visited_[tmp.x][tmp.y - 1] && field_[tmp.x][tmp.y - 1] == 1) {
                            visited_[tmp.x][tmp.y - 1] = true;
                            que.add(new Point(tmp.x, tmp.y - 1));
                        }
                    }
                }
            }
        }

        return result;
    }

    class Point {
        int x;
        int y;
        public Point(int inX, int inY) {
            this.x = inX;
            this.y = inY;
        }
    }
}
