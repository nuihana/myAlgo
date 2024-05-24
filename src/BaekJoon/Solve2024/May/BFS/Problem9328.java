package BaekJoon.Solve2024.May.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem9328 {
    int height, width, res;
    boolean[][] isVisited;
    char[][] map;
    boolean[] key;
    Queue<int[]> locked;
    int[] dx = { -1, 0, 1, 0 };
    int[] dy = { 0, 1, 0, -1 };

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int caseCnt = Integer.parseInt(br.readLine());
        while (caseCnt-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            height = Integer.parseInt(st.nextToken());
            width = Integer.parseInt(st.nextToken());
            res = 0;

            locked = new LinkedList<>();
            map = new char[height + 2][width + 2];
            isVisited = new boolean[height + 2][width + 2];
            for (int i = 1; i <= height; i++) {
                String line = br.readLine();
                for (int j = 1; j <= width; j++) {
                    map[i][j] = line.charAt(j - 1);
                }
            }

            key = new boolean[26];
            String ownKey = br.readLine();
            if (!ownKey.equals("0")) {
                for (int i = 0; i < ownKey.length(); i++) {
                    char c = ownKey.charAt(i);
                    int tmp = c - 'a';
                    key[tmp] = true;
                }
            }

            bfs(0, 0);

            while (true) {
                boolean isUpdate = false;
                int size = locked.size();
                while (size-- > 0) {
                    int[] now = locked.poll();
                    if (key[map[now[0]][now[1]] - 'A']) {
                        isUpdate = true;
                        bfs(now[0], now[1]);
                    } else {
                        locked.offer(now);
                    }
                }

                if (!isUpdate || locked.isEmpty()) break;
            }

            System.out.println(res);
        }

        br.close();
    }

    private void bfs(int r, int c) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{ r, c });
        isVisited[r][c] = true;
        while (!q.isEmpty()) {
            int[] now = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];
                if (nx < 0 || nx >= height + 2 || ny < 0 || ny >= width + 2 || isVisited[nx][ny] || map[nx][ny] == '*') continue;
                isVisited[nx][ny] = true;
                if (map[nx][ny] >= 'a' && map[nx][ny] <= 'z') {
                    key[map[nx][ny] - 'a'] = true;
                    q.offer(new int[]{ nx, ny });
                } else if (map[nx][ny] >= 'A' && map[nx][ny] <= 'Z') {
                    if (key[map[nx][ny] - 'A']) q.offer(new int[]{ nx, ny });
                    else locked.offer(new int[]{ nx, ny });
                } else {
                    if (map[nx][ny] == '$') res++;
                    q.offer(new int[]{ nx, ny });
                }
            }
        }
    }
}
