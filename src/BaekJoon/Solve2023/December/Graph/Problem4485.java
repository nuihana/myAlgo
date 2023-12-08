package BaekJoon.Solve2023.December.Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.MessageFormat;
import java.util.*;

public class Problem4485 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int idx = 1;
        int[] dx = { -1, 0, 1, 0 };
        int[] dy = { 0, 1, 0, -1 };
        while (true) {
            int n = Integer.parseInt(br.readLine());
            if (n == 0) break;

            int[][] cost = new int[n][n];
            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    cost[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            boolean[][] visit = new boolean[n][n];
            int[][] result = new int[n][n];
            Queue<int[]> que = new PriorityQueue<>((a1, a2) -> a1[2] - a2[2]);
            result[0][0] = cost[0][0];
            visit[0][0] = true;
            que.offer(new int[]{ 0, 0, cost[0][0] });

            while (!que.isEmpty()) {
                int[] now = que.poll();

                for (int i = 0; i < 4; i++) {
                    int[] next = { now[0] + dx[i], now[1] + dy[i], now[2] };
                    if (next[0] >= 0 && next[0] < n && next[1] >= 0 && next[1] < n) {
                        if (!visit[next[0]][next[1]]) {
                            next[2] += cost[next[0]][next[1]];
                            visit[next[0]][next[1]] = true;
                            result[next[0]][next[1]] = next[2];
                            que.offer(next);
                        }
                    }
                }
            }

            System.out.println(MessageFormat.format("Problem {0}: {1}", idx++, result[n - 1][n - 1]));
        }

        br.close();
    }
}
