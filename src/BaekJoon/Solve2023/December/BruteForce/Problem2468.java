package BaekJoon.Solve2023.December.BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem2468 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[][] field = new int[n][n];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n ; j++) {
                field[i][j] = Integer.parseInt(st.nextToken());
                max =Math.max(max, field[i][j]);
            }
        }

        int[] dx = { -1, 0, 1, 0 };
        int[] dy = { 0, 1, 0, -1 };
        int result = 0;
        while (max-- > 0) {
            boolean[][] isSink = new boolean[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n ; j++) {
                    if (field[i][j] <= max) isSink[i][j] = true;
                }
            }

            int cnt = 0;
            Queue<int[]> que = new LinkedList<>();
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n ; j++) {
                    if (isSink[i][j]) continue;
                    cnt++;
                    isSink[i][j] = true;
                    que.offer(new int[]{ i, j });
                    while (!que.isEmpty()) {
                        int[] now = que.poll();
                        for (int k = 0; k < 4; k++) {
                            int[] next = { now[0] + dx[k], now[1] + dy[k] };
                            if (next[0] >= 0 && next[0] < n && next[1] >= 0 && next[1] < n && !isSink[next[0]][next[1]]) {
                                isSink[next[0]][next[1]] = true;
                                que.offer(next);
                            }
                        }
                    }
                }
            }

            result = Math.max(result, cnt);
        }

        System.out.println(result);

        br.close();
    }
}
