package BaekJoon.Solve2023.June.CP_BruteForce_Recursive;

import java.io.*;
import java.util.*;

public class Problem16197 {
    int height;
    int width;
    Coins coins;
    int[][] field;
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        height = Integer.parseInt(st.nextToken());
        width = Integer.parseInt(st.nextToken());
        field = new int[height][width];

        coins = new Coins();
        for (int i = 0; i < height; i++) {
            String line = br.readLine();
            for (int j = 0; j < width; j++) {
                char tmp = line.charAt(j);
                if (tmp == '.') {
                    field[i][j] = 0;
                } else if (tmp == '#') {
                    field[i][j] = 1;
                } else if (tmp == 'o') {
                    field[i][j] = 2;
                    if (coins.coin1 == null) {
                        coins.coin1 = new Point(i, j);
                    } else {
                        coins.coin2 = new Point(i, j);
                    }
                }
            }
        }

        bw.write(String.valueOf(bfs()));

        br.close();
        bw.close();
    }

    private int bfs() {
        Queue<Coins> que = new LinkedList<>();
        que.offer(coins);

        while(!que.isEmpty()) {
            Coins tmpCoins = que.poll();

            int fallCnt = tmpCoins.getFallCnt();
            if (fallCnt == 2) continue;
            if (tmpCoins.turn > 10) continue;
            if (fallCnt == 1) {
                return tmpCoins.turn;
            }

            //위
            if (tmpCoins.isMovable(-1, 0)) {
                que.offer(new Coins(tmpCoins.coin1.move(-1, 0), tmpCoins.coin2.move(-1, 0), tmpCoins.turn + 1));
            }
            //오른쪽
            if (tmpCoins.isMovable(0, 1)) {
                que.offer(new Coins(tmpCoins.coin1.move(0, 1), tmpCoins.coin2.move(0, 1), tmpCoins.turn + 1));
            }
            //아래
            if (tmpCoins.isMovable(1, 0)) {
                que.offer(new Coins(tmpCoins.coin1.move(1, 0), tmpCoins.coin2.move(1, 0), tmpCoins.turn + 1));
            }
            //왼쪽
            if (tmpCoins.isMovable(0, -1)) {
                que.offer(new Coins(tmpCoins.coin1.move(0, -1), tmpCoins.coin2.move(0, -1), tmpCoins.turn + 1));
            }
        }

        return -1;
    }

    class Coins {
        Point coin1;
        Point coin2;
        int turn;

        public Coins() {
            turn = 0;
        }
        public Coins(Point c1, Point c2, int turn_) {
            this.coin1 = c1;
            this.coin2 = c2;
            this.turn = turn_;
        }

        public boolean isMovable(int x, int y) {
            Point df_coin1 = coin1.move(x, y);
            Point df_coin2 = coin2.move(x, y);
            //겹치면 fail
            if (df_coin1.equals(df_coin2)) {
                return false;
            }

            //두개다 떨어지면 fail
            if (df_coin1.isFall() + df_coin2.isFall() == 2) {
                return false;
            }

            return true;
        }
        public int getFallCnt() {
            return coin1.isFall() + coin2.isFall();
        }
    }

    class Point {
        int x;
        int y;

        public Point(int x_, int y_) {
            this.x = x_;
            this.y = y_;
        }

        public Point move(int dx, int dy) {
            int final_x = x + dx;
            int final_y = y + dy;

            if (final_x < 0 || final_x >= height || final_y < 0 || final_y >= width) {
                return new Point(final_x, final_y);
            } else if (field[final_x][final_y] == 1) {
                return new Point(x, y);
            } else {
                return new Point(final_x, final_y);
            }
        }
        public int isFall() {
            if (x < 0 || x >= height) {
                return 1;
            }
            if (y < 0 || y >= width) {
                return 1;
            }
            return 0;
        }

        @Override
        public boolean equals(Object obj) {
            Point another = (Point) obj;
            if (another.x == this.x) {
                return another.y == this.y;
            }
            return false;
        }
    }
}
