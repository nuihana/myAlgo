package BaekJoon.Solve2023.April.Random;

import java.io.*;
import java.util.*;

public class Problem16236 {
    int fieldSize;
    int[][] field;
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        fieldSize = Integer.parseInt(br.readLine());
        field = new int[fieldSize][fieldSize];

        Shark shark = null;
        for (int i = 0; i < fieldSize; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; st.hasMoreTokens(); j++) {
                field[j][i] = Integer.parseInt(st.nextToken());

                if (field[j][i] == 9) {
                    shark = new Shark(j, i);
                    field[j][i] = 0;
                }
            }
        }

        Point feedIdx = bfs(shark);
        while(feedIdx != null) {
            shark.eat(feedIdx);

            feedIdx = bfs(shark);
        }

        bw.write(String.valueOf(shark.moveLength));

        br.close();
        bw.close();
    }

    private Point bfs(Shark shark) {
        PriorityQueue<Point> que = new PriorityQueue<>((p1, p2) -> p1.compareTo(p2));
        boolean[][] visited = new boolean[fieldSize][fieldSize];
        visited[shark.x][shark.y] = true;
        que.add(new Point(shark.x, shark.y, 0));

        while (!que.isEmpty()) {
            Point tmp = que.poll();

            if (field[tmp.x][tmp.y] < shark.size && field[tmp.x][tmp.y] > 0) {
                return new Point(tmp.x, tmp.y, tmp.cost);
            }

            if (tmp.y > 0 && !visited[tmp.x][tmp.y - 1] && field[tmp.x][tmp.y - 1] <= shark.size) {
                visited[tmp.x][tmp.y - 1] = true;
                que.add(new Point(tmp.x, tmp.y - 1, tmp.cost + 1));
            }

            if (tmp.x > 0 && !visited[tmp.x - 1][tmp.y] && field[tmp.x - 1][tmp.y] <= shark.size) {
                visited[tmp.x - 1][tmp.y] = true;
                que.add(new Point(tmp.x - 1, tmp.y, tmp.cost + 1));
            }

            if (tmp.x < fieldSize - 1 && !visited[tmp.x + 1][tmp.y] && field[tmp.x + 1][tmp.y] <= shark.size) {
                visited[tmp.x + 1][tmp.y] = true;
                que.add(new Point(tmp.x + 1, tmp.y, tmp.cost + 1));
            }

            if (tmp.y < fieldSize - 1 && !visited[tmp.x][tmp.y + 1] && field[tmp.x][tmp.y + 1] <= shark.size) {
                visited[tmp.x][tmp.y + 1] = true;
                que.add(new Point(tmp.x, tmp.y + 1, tmp.cost + 1));
            }
        }

        return null;
    }

    class Shark {
        int x;
        int y;
        int size;
        int eatCnt;
        int moveLength;

        public Shark(int x_, int y_) {
            this.x = x_;
            this.y = y_;
            size = 2;
            eatCnt = 0;
            moveLength = 0;
        }

        public void eat(Point p) {
            moveLength += p.cost;
            x = p.x;
            y = p.y;

            eatCnt++;
            field[x][y] = 0;
            digest();
        }
        private void digest() {
            if (size == eatCnt) {
                size++;
                eatCnt = 0;
            }
        }
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

        public int compareTo(Point another) {
            if (another.cost < this.cost) {
                return 1;
            } else if (another.cost > this.cost) {
                return -1;
            }

            if (another.y < this.y) {
                return 1;
            } else if (another.y > this.y) {
                return -1;
            }

            if (another.x < this.x) {
                return 1;
            } else if (another.x > this.x) {
                return -1;
            }

            return 0;
        }
    }
}
