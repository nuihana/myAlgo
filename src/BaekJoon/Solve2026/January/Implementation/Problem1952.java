package BaekJoon.Solve2026.January.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem1952 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int row = Integer.parseInt(st.nextToken());
        int col = Integer.parseInt(st.nextToken());

        boolean[][] map = new boolean[row][col];
        int x = 0, y = 0, dir = 0, sum = 1, res = 0;
        int[] dx = { 0, 1, 0, -1 };
        int[] dy = { 1, 0, -1, 0 };
        map[x][y] = true;
        while (true) {
            if (sum == row * col) break;

            int nx = x + dx[dir];
            int ny = y + dy[dir];
            if (nx >= 0 && nx < row && ny >= 0 && ny < col && !map[nx][ny]) {
                sum++;
                map[nx][ny] = true;
                x = nx;
                y = ny;
            } else {
                res++;
                dir = (dir + 1) % 4;
            }
        }
        System.out.print(res);

        br.close();
    }
}
