package BaekJoon.Solve2024.February.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Problem2665 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[][] field = new int[n][n];
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < n; j++) {
                field[i][j] = line.charAt(j) - '0';
            }
        }

        Queue<int[]> q = new LinkedList<>();
        int[][] cost = new int[n][n];
        for (int i = 0; i < n; i++) Arrays.fill(cost[i], 2501);
        q.offer(new int[]{ 0, 0, 0 });
        cost[0][0] = 0;

        int[] dx = { -1, 0, 1, 0 };
        int[] dy = { 0, 1, 0, -1 };
        while (!q.isEmpty()) {
            int[] now = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];
                if (nx < 0 || nx >= n || ny < 0 || ny >= n || cost[nx][ny] <= now[2]) continue;
                if (field[nx][ny] == 0) {
                    cost[nx][ny] = now[2] + 1;
                    q.offer(new int[]{ nx, ny, now[2] + 1 });
                } else {
                    cost[nx][ny] = now[2];
                    q.offer(new int[]{ nx, ny, now[2] });
                }
            }
        }

        System.out.print(cost[n - 1][n - 1]);

        br.close();
    }
}
