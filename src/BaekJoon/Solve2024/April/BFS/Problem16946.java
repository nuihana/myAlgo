package BaekJoon.Solve2024.April.BFS;

import java.io.*;
import java.util.*;

public class Problem16946 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int height = Integer.parseInt(st.nextToken());
        int width = Integer.parseInt(st.nextToken());
        char[][] map = new char[height][width];
        List<int[]> wall = new ArrayList<>();

        for (int i = 0; i < height; i++) {
            String line = br.readLine();
            for (int j = 0; j < width; j++) {
                map[i][j] = line.charAt(j);
                if (map[i][j] == '1') wall.add(new int[]{ i, j });
            }
        }

        int[] dx = { -1, 0, 1, 0 };
        int[] dy = { 0, 1, 0, -1 };

        List<Integer> groupCnt = new ArrayList<>();
        int[][] groupId = new int[height][width];
        groupCnt.add(0);
        int idx = 1;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (map[i][j] == '0' && groupId[i][j] == 0) {
                    int cnt = 0;
                    Queue<int[]> q = new LinkedList<>();
                    boolean[][] visited = new boolean[height][width];
                    q.offer(new int[]{ i, j });
                    visited[i][j] = true;
                    groupId[i][j] = idx;

                    while (!q.isEmpty()) {
                        int[] now = q.poll();
                        cnt++;

                        for (int k = 0; k < 4; k++) {
                            int nx = now[0] + dx[k];
                            int ny = now[1] + dy[k];

                            if (nx < 0 || nx >= height || ny < 0 || ny >= width || visited[nx][ny] || map[nx][ny] == '1') continue;
                            visited[nx][ny] = true;
                            groupId[nx][ny] = idx;
                            q.offer(new int[]{ nx, ny });
                        }
                    }

                    groupCnt.add(cnt);
                    idx++;
                }
            }
        }

        int[][] res = new int[height][width];
        for (int[] w : wall) {
            int cnt = 1;
            boolean[] isin = new boolean[idx];

            for (int k = 0; k < 4; k++) {
                int nx = w[0] + dx[k];
                int ny = w[1] + dy[k];

                if (nx < 0 || nx >= height || ny < 0 || ny >= width || map[nx][ny] == '1' || isin[groupId[nx][ny]]) continue;
                isin[groupId[nx][ny]] = true;
                cnt += groupCnt.get(groupId[nx][ny]);
            }

            res[w[0]][w[1]] = cnt;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                sb.append(res[i][j]);
            }
            sb.append("\n");
        }
        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}
