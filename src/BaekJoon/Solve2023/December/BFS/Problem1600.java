package BaekJoon.Solve2023.December.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem1600 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int k = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        int[][] field = new int[h][w];
        for (int i = 0; i < h; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < w; j++) {
                field[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[] dx = { -1, 0, 1, 0 };
        int[] dy = { 0, 1, 0, -1 };
        int[] hx = { -2, -2, -1, 1, 2, 2, 1, -1 };
        int[] hy = { -1, 1, 2, 2, 1, -1, -2, -2 };

        Queue<Move> que = new LinkedList<>();
        boolean[][][] isVisited = new boolean[h][w][k + 1];
        isVisited[0][0][k] = true;
        que.offer(new Move(0, 0, 0, k));
        int result = Integer.MAX_VALUE;
        while (!que.isEmpty()) {
            Move now = que.poll();
            if (now.x == h - 1 && now.y == w - 1) {
                result = Math.min(result, now.turn);
                continue;
            }

            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                if (nx >= 0 && nx < h && ny >= 0 && ny < w && !isVisited[nx][ny][now.hMove] && field[nx][ny] == 0) {
                    isVisited[nx][ny][now.hMove] = true;
                    que.offer(now.side(nx, ny));
                }
            }

            if (now.hMove > 0) {
                for (int i = 0; i < 8; i++) {
                    int nx = now.x + hx[i];
                    int ny = now.y + hy[i];
                    if (nx >= 0 && nx < h && ny >= 0 && ny < w && !isVisited[nx][ny][now.hMove - 1] && field[nx][ny] == 0) {
                        isVisited[nx][ny][now.hMove - 1] = true;
                        que.offer(now.hSide(nx, ny));
                    }
                }
            }
        }

        System.out.print(result);

        br.close();
    }

    class Move {
        int turn, hMove, x, y;

        public Move(int x_, int y_, int t_, int m_) {
            x = x_;
            y = y_;
            turn = t_;
            hMove = m_;
        }

        public Move side(int nx, int ny) {
            return new Move(nx, ny, turn + 1, hMove);
        }
        public Move hSide(int nx, int ny) {
            return new Move(nx, ny, turn + 1, hMove - 1);
        }
    }
}
