package BaekJoon.Solve2024.September.Graph;

import java.io.*;
import java.util.*;

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
        q.offer(new int[]{ 0, 0 });
        cost[0][0] = 0;

        int[] dx = { -1, 0, 1, 0 };
        int[] dy = { 0, 1, 0, -1 };
        while (!q.isEmpty()) {
            int[] now = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];
                if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
                if (field[nx][ny] == 0 && cost[nx][ny] > cost[now[0]][now[1]] + 1) {
                    cost[nx][ny] = cost[now[0]][now[1]] + 1;
                    q.offer(new int[]{ nx, ny });
                } else if (field[nx][ny] == 1 && cost[nx][ny] > cost[now[0]][now[1]]) {
                    cost[nx][ny] = cost[now[0]][now[1]];
                    q.offer(new int[]{ nx, ny });
                }
            }
        }

        System.out.print(cost[n - 1][n - 1]);
        br.close();
    }
}
