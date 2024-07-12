package BaekJoon.Solve2024.July.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem20058 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int cast = Integer.parseInt(st.nextToken());

        int size = (1 << n);
        int[][] map = new int[size][size];
        for (int i = 0; i < size; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < size; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        while (cast-- > 0) {
            int level = Integer.parseInt(st.nextToken());

            map = firestorm(level, map);
        }

        int rest = 0;
        int max = 0;
        boolean[][] isCounted = new boolean[size][size];
        int[] dx = { -1, 0, 1, 0 };
        int[] dy = { 0, 1, 0, -1 };
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                rest += map[i][j];

                if (map[i][j] > 0 && !isCounted[i][j]) {
                    Queue<int[]> q = new LinkedList<>();
                    q.offer(new int[]{ i, j });
                    isCounted[i][j] = true;

                    int area = 1;
                    while (!q.isEmpty()) {
                        int[] now = q.poll();

                        for (int k = 0; k < 4; k++) {
                            int nx = now[0] + dx[k];
                            int ny = now[1] + dy[k];
                            if (nx < 0 || nx >= size || ny < 0 || ny >= size || isCounted[nx][ny] || map[nx][ny] == 0) continue;
                            isCounted[nx][ny] = true;
                            q.offer(new int[]{ nx, ny });
                            area++;
                        }
                    }

                    max = Math.max(max, area);
                }
            }
        }

        System.out.println(rest);
        System.out.print(max);

        br.close();
    }

    private int[][] firestorm(int level, int[][] map) {
        int size = (1 << level);

        int[][] after = new int[map.length][map.length];

        int x = 0, y = 0;
        while (x < map.length) {
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    after[j + x][y + size - 1 - i] = map[x + i][y + j];
                }
            }

            y += size;
            if (y >= map.length) {
                x += size;
                y = 0;
            }
        }

        int[] dx = { -1, 0, 1, 0 };
        int[] dy = { 0, 1, 0, -1 };
        for (int i = 0; i < after.length; i++) {
            for (int j = 0; j < after.length; j++) {
                int side = 0;
                for (int k = 0; k < 4; k++) {
                    int nx = i + dx[k];
                    int ny = j + dy[k];

                    if (nx < 0 || nx >= after.length || ny < 0 || ny >= after.length) continue;
                    if (after[nx][ny] > 0) side++;
                }

                if (after[i][j] > 0 && side < 3) {
                    map[i][j] = after[i][j] - 1;
                } else {
                    map[i][j] = after[i][j];
                }
            }
        }

        return map;
    }
}
