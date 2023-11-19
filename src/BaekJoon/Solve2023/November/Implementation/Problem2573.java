package BaekJoon.Solve2023.November.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem2573 {
    int[][] sea;
    int[] dx = { 1, 0, -1, 0 };
    int[] dy = { 0, 1, 0, -1 };

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int height = Integer.parseInt(st.nextToken());
        int width = Integer.parseInt(st.nextToken());

        sea = new int[height][width];
        for (int i = 0; i < height; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < width; j++) {
                sea[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int turn = 0;
        while (true) {
            int flag = isDivided(height, width);
            if (flag < 0) {
                turn = 0;
                break;
            }
            if (flag > 0) break;
            melt(height, width);
            turn++;
        }
        System.out.print(turn);

        br.close();
    }

    private int isDivided(int h, int w) {
        boolean[][] isVisited = new boolean[h][w];
        int idx = -1;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (isVisited[i][j]) continue;
                isVisited[i][j] = true;
                if (sea[i][j] == 0) continue;

                Queue<int[]> que = new LinkedList<>();
                que.offer(new int[]{ i, j });
                while (!que.isEmpty()) {
                    int[] now = que.poll();

                    for (int k = 0; k < 4; k++) {
                        int[] next = { now[0] + dx[k], now[1] + dy[k] };

                        if (next[0] < 0 || next[1] < 0 || next[0] >= h || next[1] >= w) continue;
                        if (!isVisited[next[0]][next[1]] && sea[next[0]][next[1]] > 0) {
                            isVisited[next[0]][next[1]] = true;
                            que.offer(new int[]{ next[0], next[1] });
                        }
                    }
                }

                idx++;
            }
        }

        return idx;
    }

    private void melt(int h, int w) {
        int[][] melt = new int[h][w];

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (sea[i][j] == 0) continue;

                int beside = 0;
                for (int k = 0; k < 4; k++) {
                    int[] next = { i + dx[k], j + dy[k] };

                    if (next[0] < 0 || next[1] < 0 || next[0] >= h || next[1] >= w) continue;
                    if (sea[next[0]][next[1]] == 0) beside++;
                }
                melt[i][j] = beside;
            }
        }

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (melt[i][j] == 0) continue;
                sea[i][j] = Math.max(0, sea[i][j] - melt[i][j]);
            }
        }
    }
}
