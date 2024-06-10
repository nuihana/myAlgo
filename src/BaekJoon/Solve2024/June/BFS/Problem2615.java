package BaekJoon.Solve2024.June.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem2615 {
    int[][] map;
    int[] dx = { -1, -1, 0, 1, 1, 1, 0, -1 };
    int[] dy = { 0, 1, 1, 1, 0, -1, -1, -1 };

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        map = new int[19][19];
        for (int i = 0; i < 19; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 19; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < 19; i++) {
            for (int j = 0; j < 19; j++) {
                if (map[i][j] > 0) {
                    int[] tmp = isDone(i, j, map[i][j]);

                    if (tmp != null) {
                        System.out.println(map[i][j]);
                        System.out.print(tmp[0] + " " + tmp[1]);
                        return;
                    }
                }
            }
        }

        System.out.print("0");

        br.close();
    }

    private int[] isDone(int x, int y, int col) {
        int[] res = null;
        for (int i = 0; i < 8; i++) {
            int len = straightLength(x, y, col, i);
            if (len == 5) {
                res = new int[2];

                if (i == 0) {
                    x -= 4;
                } else if (i == 5) {
                    x += 4;
                    y -= 4;
                } else if (i == 6) {
                    y -= 4;
                } else if (i == 7) {
                    x -= 4;
                    y -= 4;
                }

                res[0] = x + 1;
                res[1] = y + 1;

                return res;
            }
        }

        return res;
    }

    private int straightLength(int x, int y, int col, int dir) {
        int len = 0;

        int tx = x;
        int ty = y;
        while (tx >= 0 && tx < 19 && ty >= 0 && ty < 19 && map[tx][ty] == col) {
            len++;
            tx += dx[dir];
            ty += dy[dir];
        }

        int tdir = (dir + 4) % 8;
        tx = x + dx[tdir];
        ty = y + dy[tdir];
        if (tx >= 0 && tx < 19 && ty >= 0 && ty < 19 && map[tx][ty] == col) return 0;

        return len;
    }
}
