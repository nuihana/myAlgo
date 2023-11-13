package BaekJoon.Solve2023.November.Conte_SASA;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem30508 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());

        int[][] field = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                field[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        boolean[][] isNotFilled = new boolean[n][m];
        Queue<int[]> que = new LinkedList<>();
        int k = Integer.parseInt(br.readLine());
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;

            isNotFilled[r][c] = true;
            que.offer(new int[]{ r, c });
        }

        int[] dx = { 0, 1, 0, -1 };
        int[] dy = { -1, 0, 1, 0 };
        while (!que.isEmpty()) {
            int[] now = que.poll();

            int val = field[now[0]][now[1]];
            for (int i = 0; i < 4; i++) {
                int[] next = { now[0] + dy[i], now[1] + dx[i] };

                if (next[0] < 0 || next[1] < 0 || next[0] >= n || next[1] >= m) continue;
                if (isNotFilled[next[0]][next[1]]) continue;

                if (field[next[0]][next[1]] >= val) {
                    isNotFilled[next[0]][next[1]] = true;
                    que.offer(next);
                }
            }
        }

        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i + h > n || j + w > m) continue;
                boolean flag = true;
                for (int di = i; di < i + h; di++) {
                    for (int dj = j; dj < j + w; dj++) {
                        if (!isNotFilled[di][dj]) {
                            flag = false;
                            break;
                        }
                    }
                }

                if (flag) res++;
            }
        }

        bw.write(String.valueOf(res));

        bw.close();
        br.close();
    }
}
