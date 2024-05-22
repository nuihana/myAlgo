package BaekJoon.Solve2024.May.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem3197 {
    int[] uf;
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int height = Integer.parseInt(st.nextToken());
        int width = Integer.parseInt(st.nextToken());

        int[][] map = new int[height][width];
        for (int i = 0; i < height; i++) {
            String line = br.readLine();
            for (int j = 0; j < width; j++) {
                char c = line.charAt(j);

                if (c == 'X') {
                    map[i][j] = -1;
                }

                if (c == 'L') {
                    map[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        int idx = 1;
        int from = -1;
        int to = -1;
        int[] dx = { -1, 0, 1, 0 };
        int[] dy = { 0, 1, 0, -1 };
        boolean[][] isIncluded = new boolean[height][width];
        Queue<int[]> tq = new LinkedList<>();
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (map[i][j] >= 0 && !isIncluded[i][j]) {
                    isIncluded[i][j] = true;

                    Queue<int[]> q = new LinkedList<>();
                    q.offer(new int[]{ i, j });

                    while (!q.isEmpty()) {
                        int[] now = q.poll();

                        if (map[now[0]][now[1]] == Integer.MAX_VALUE) {
                            if (from < 0) from = idx;
                            else to = idx;
                        }

                        tq.offer(new int[]{ now[0], now[1], idx });
                        map[now[0]][now[1]] = idx;

                        for (int k = 0; k < 4; k++) {
                            int nx = now[0] + dx[k];
                            int ny = now[1] + dy[k];

                            if (nx < 0 || nx >= height || ny < 0 || ny >= width || isIncluded[nx][ny] || map[nx][ny] < 0) continue;
                            isIncluded[nx][ny] = true;
                            q.offer(new int[]{ nx, ny });
                        }
                    }

                    idx++;
                }
            }
        }

        uf = new int[idx];
        for (int i = 1; i < idx; i++) uf[i] = i;
        int res = 0;
        while (find(from) != find(to)) {
            Queue<int[]> nq = new LinkedList<>();
            //녹이기
            while (!tq.isEmpty()) {
                int[] now = tq.poll();

                for (int k = 0; k < 4; k++) {
                    int nx = now[0] + dx[k];
                    int ny = now[1] + dy[k];

                    if (nx < 0 || nx >= height || ny < 0 || ny >= width || isIncluded[nx][ny] || map[nx][ny] == now[2]) continue;
                    isIncluded[nx][ny] = true;
                    if (map[nx][ny] > 0) union(now[2], map[nx][ny]);
                    map[nx][ny] = now[2];
                    nq.offer(new int[]{ nx, ny, now[2] });
                }
            }

            int cnt = nq.size();
            while (cnt-- > 0) {
                int[] now = nq.poll();
                for (int k = 0; k < 4; k++) {
                    int nx = now[0] + dx[k];
                    int ny = now[1] + dy[k];

                    if (nx < 0 || nx >= height || ny < 0 || ny >= width || map[nx][ny] == now[2]) continue;
                    if (map[nx][ny] > 0) union(now[2], map[nx][ny]);
                }
                nq.offer(now);
            }
            tq = nq;
            res++;
        }

        System.out.print(res);

        br.close();
    }

    private int find(int id) {
        if (uf[id] == id) return id;
        return find(uf[id]);
    }

    private void union(int a, int b) {
        int root_a = find(a);
        int root_b = find(b);
        if (root_a != root_b) {
            uf[root_b] = root_a;
        }
    }
}
