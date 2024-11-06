package BaekJoon.Solve2024.November.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem1347 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int len = Integer.parseInt(br.readLine());
        boolean[][] map = new boolean[102][102];

        int x = 50, y = 50, dir = 0;
        int[] dx = { 1, 0, -1, 0 };
        int[] dy = { 0, -1, 0, 1 };

        String log = br.readLine();
        for (int i = 0; i < len; i++) {
            map[x][y] = true;

            char now = log.charAt(i);
            if (now == 'R') {
                dir++;
                if (dir == 4) dir = 0;
            } else if (now == 'L') {
                dir--;
                if (dir == -1) dir = 3;
            } else {
                x += dx[dir];
                y += dy[dir];
            }
        }
        map[x][y] = true;

        int sx = 101, sy = 101, ex = 0, ey = 0;
        for (int i = 0; i < 102; i++) {
            for (int j = 0; j < 102; j++) {
                if (map[i][j]) {
                    sx = Math.min(sx, i);
                    sy = Math.min(sy, j);
                    ex = Math.max(ex, i);
                    ey = Math.max(ey, j);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = sx; i <= ex; i++) {
            for (int j = sy; j <= ey; j++) {
                if (map[i][j]) {
                    sb.append(".");
                } else {
                    sb.append("#");
                }
            }
            sb.append("\n");
        }
        System.out.print(sb);

        br.close();
    }
}
