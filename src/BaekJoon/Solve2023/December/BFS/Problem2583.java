package BaekJoon.Solve2023.December.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Problem2583 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int height = Integer.parseInt(st.nextToken());
        int width = Integer.parseInt(st.nextToken());
        int sqrCnt = Integer.parseInt(st.nextToken());

        boolean[][] field = new boolean[height][width];
        for (int i = 0; i < sqrCnt; i++) {
            st = new StringTokenizer(br.readLine());
            int lbx = Integer.parseInt(st.nextToken());
            int lby = Integer.parseInt(st.nextToken());

            int rtx = Integer.parseInt(st.nextToken());
            int rty = Integer.parseInt(st.nextToken());

            for (int x = lbx; x < rtx; x++) {
                for (int y = lby; y < rty; y++) {
                    field[y][x] = true;
                }
            }
        }

        List<Integer> res = new ArrayList<>();
        Queue<int[]> que = new LinkedList<>();
        int[] dx = { -1, 0, 1, 0 };
        int[] dy = { 0, 1, 0, -1 };
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (!field[i][j]) {
                    que.offer(new int[]{ i, j });
                    field[i][j] = true;

                    int cnt = 0;
                    while (!que.isEmpty()) {
                        int[] now = que.poll();
                        cnt++;

                        for (int k = 0; k < 4; k++) {
                            int nx = now[0] + dx[k];
                            int ny = now[1] + dy[k];
                            if (nx < 0 || nx >= height || ny < 0 || ny >= width || field[nx][ny]) continue;
                            field[nx][ny] = true;
                            que.offer(new int[]{ nx, ny });
                        }
                    }

                    res.add(cnt);
                }
            }
        }

        System.out.println(res.size());
        res.sort(Comparator.naturalOrder());
        for (int cnt : res) {
            System.out.print(cnt + " ");
        }

        br.close();
    }
}
