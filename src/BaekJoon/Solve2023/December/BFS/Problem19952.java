package BaekJoon.Solve2023.December.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem19952 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCnt = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (testCnt-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int height = Integer.parseInt(st.nextToken());
            int width = Integer.parseInt(st.nextToken());

            int obstacle = Integer.parseInt(st.nextToken());

            int force = Integer.parseInt(st.nextToken());
            int sx = Integer.parseInt(st.nextToken());
            int sy = Integer.parseInt(st.nextToken());
            int ex = Integer.parseInt(st.nextToken());
            int ey = Integer.parseInt(st.nextToken());

            int[][] field = new int[height + 1][width + 1];
            for (int i = 0; i < obstacle; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int l = Integer.parseInt(st.nextToken());

                field[x][y] = l;
            }

            boolean[][] isVisit = new boolean[height + 1][width + 1];
            Queue<int[]> que = new LinkedList<>();
            que.offer(new int[]{ sx, sy, force });
            isVisit[sx][sy] = true;
            int[] dx = { -1, 0, 1, 0 };
            int[] dy = { 0, 1, 0, -1 };
            boolean res = false;
            while (!que.isEmpty()) {
                int[] now = que.poll();
                if (now[0] == ex && now[1] == ey) {
                    res = true;
                    break;
                }
                if (now[2] <= 0) continue;

                for (int i = 0; i < 4; i++) {
                    int nx = now[0] + dx[i];
                    int ny = now[1] + dy[i];

                    if (nx < 1 || nx > height || ny < 1 || ny > width) continue;
                    if (field[nx][ny] - field[now[0]][now[1]] <= now[2] && !isVisit[nx][ny]) {
                        isVisit[nx][ny] = true;
                        que.offer(new int[]{ nx, ny, now[2] - 1 });
                    }
                }
            }

            if (res) {
                sb.append("잘했어!!\n");
            } else {
                sb.append("인성 문제있어??\n");
            }
        }

        System.out.print(sb);

        br.close();
    }
}
