package BaekJoon.Solve2023.December.Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem2146 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[][] map = new int[n][n];
        int[][] maptwo = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        boolean[][] isVisited = new boolean[n][n];
        Queue<int[]> que = new LinkedList<>();
        int[] dx = { -1, 0, 1, 0 };
        int[] dy = { 0, 1, 0, -1 };
        int idx = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 1 && !isVisited[i][j]) {
                    idx++;
                    Queue<int[]> tmp = new LinkedList<>();
                    tmp.offer(new int[]{ i, j, idx });
                    isVisited[i][j] = true;
                    while (!tmp.isEmpty()) {
                        int[] now = tmp.poll();
                        que.offer(now);
                        maptwo[now[0]][now[1]] = idx;
                        for (int k = 0; k < 4; k++) {
                            int[] next = { now[0] + dx[k], now[1] + dy[k], idx };
                            if (next[0] < 0 || next[0] >= n || next[1] < 0 || next[1] >= n || isVisited[next[0]][next[1]]) continue;
                            isVisited[next[0]][next[1]] = true;
                            if (map[next[0]][next[1]] == 1) {
                                tmp.offer(next);
                            }
                        }
                    }
                }
            }
        }

        int result = Integer.MAX_VALUE;
        while (!que.isEmpty()) {
            int[] now = que.poll();
            for (int i = 0; i < 4; i++) {
                int[] next = { now[0] + dx[i], now[1] + dy[i], now[2] };
                if (next[0] < 0 || next[0] >= n || next[1] < 0 || next[1] >= n || maptwo[next[0]][next[1]] == now[2]) continue;
                if (maptwo[next[0]][next[1]] != 0) {
                    result = Math.min(result, map[next[0]][next[1]] + map[now[0]][now[1]] - 2);
                } else {
                    map[next[0]][next[1]] = map[now[0]][now[1]] + 1;
                    maptwo[next[0]][next[1]] = next[2];
                    que.offer(next);
                }
            }
        }

        System.out.print(result);

        br.close();
    }
}
