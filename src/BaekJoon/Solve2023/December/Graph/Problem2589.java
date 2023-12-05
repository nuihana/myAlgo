package BaekJoon.Solve2023.December.Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Problem2589 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int height = Integer.parseInt(st.nextToken());
        int width = Integer.parseInt(st.nextToken());

        char[][] map = new char[height][width];
        for (int i = 0; i < height; i++) {
            String line = br.readLine();
            for (int j = 0; j < width; j++) {
                map[i][j] = line.charAt(j);
            }
        }

        List<List<int[]>> landList = new ArrayList<>();
        boolean[][] isVisited = new boolean[height][width];
        int[] dx = { -1, 0, 1, 0 };
        int[] dy = { 0, 1, 0, -1 };
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (isVisited[i][j]) continue;
                isVisited[i][j] = true;
                if (map[i][j] == 'L') {
                    List<int[]> land = new ArrayList<>();
                    Queue<int[]> que = new LinkedList<>();
                    land.add(new int[]{ i, j });
                    que.offer(new int[]{ i, j });
                    while (!que.isEmpty()) {
                        int[] now = que.poll();
                        for (int k = 0; k < 4; k++) {
                            int[] next = { now[0] + dx[k], now[1] + dy[k] };
                            if (next[0] < 0 || next[0] >= height || next[1] < 0 || next[1] >= width || isVisited[next[0]][next[1]]) continue;
                            isVisited[next[0]][next[1]] = true;
                            if (map[next[0]][next[1]] == 'L') {
                                que.offer(next);
                                land.add(next);
                            }
                        }
                    }

                    landList.add(land);
                }
            }
        }

        int result = 0;
        for (List<int[]> land : landList) {
            for (int[] block : land) {
                Queue<int[]> que = new LinkedList<>();
                isVisited = new boolean[height][width];
                que.offer(new int[]{ block[0], block[1], 0 });
                isVisited[block[0]][block[1]] = true;
                while (!que.isEmpty()) {
                    int[] now = que.poll();
                    for (int k = 0; k < 4; k++) {
                        int[] next = { now[0] + dx[k], now[1] + dy[k], now[2] + 1 };
                        if (next[0] < 0 || next[0] >= height || next[1] < 0 || next[1] >= width || isVisited[next[0]][next[1]]) continue;
                        isVisited[next[0]][next[1]] = true;
                        if (map[next[0]][next[1]] == 'L') {
                            que.offer(next);
                            result = Math.max(result, next[2]);
                        }
                    }
                }
            }
        }

        System.out.print(result);

        br.close();
    }
}
