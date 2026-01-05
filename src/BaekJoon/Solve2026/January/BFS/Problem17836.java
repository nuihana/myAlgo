package BaekJoon.Solve2026.January.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem17836 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int row = Integer.parseInt(st.nextToken());
        int col = Integer.parseInt(st.nextToken());
        int limit = Integer.parseInt(st.nextToken());
        final int MAXIMUM = 10001;

        int[][] map = new int[row][col];
        for (int i = 0; i < row; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < col; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Queue<int[]> q = new LinkedList<>();
        int[][] time = new int[row][col];
        q.offer(new int[]{ 0, 0, 0, 0 }); // x, y, time, sword
        for (int i = 0; i < row; i++) {
            Arrays.fill(time[i], MAXIMUM);
        }
        time[0][0] = 0;
        int[] dx = { 0, 1, 0, -1 };
        int[] dy = { -1, 0, 1, 0 };
        while (!q.isEmpty()) {
            int[] now = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];

                if (nx >= 0 && row > nx && ny >= 0 && col > ny) {
                    if (map[nx][ny] == 0 || now[3] == 1) {
                        if (time[nx][ny] > now[2] + 1) {
                            time[nx][ny] = now[2] + 1;
                            q.offer(new int[]{ nx, ny, now[2] + 1, now[3]});
                        }
                    } else if (map[nx][ny] == 2) {
                        time[row - 1][col - 1] = Math.min(time[row - 1][col - 1], now[2] + row - nx + col - ny - 1);
                    }
                }
            }
        }

        if (time[row - 1][col - 1] > limit) {
            System.out.print("Fail");
        } else {
            System.out.print(time[row - 1][col - 1]);
        }

        br.close();
    }
}
