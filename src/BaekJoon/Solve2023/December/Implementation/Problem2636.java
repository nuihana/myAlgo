package BaekJoon.Solve2023.December.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem2636 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int height = Integer.parseInt(st.nextToken());
        int width = Integer.parseInt(st.nextToken());

        int[][] field = new int[height][width];
        for (int i = 0; i < height; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < width; j++) {
                field[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Queue<int[]> que = new LinkedList<>();
        Queue<int[]> isMelt = new LinkedList<>();
        int[] dx = { -1, 0, 1, 0 };
        int[] dy = { 0, 1, 0, -1 };
        int last = 0;
        int turn = 0;
        while (true) {
            boolean[][] isVisited = new boolean[height][width];
            que.offer(new int[]{ 0, 0 });
            isVisited[0][0] = true;

            while (!que.isEmpty()) {
                int[] now = que.poll();
                for (int i = 0; i < 4; i++) {
                    int[] next = { now[0] + dx[i], now[1] + dy[i] };
                    if (next[0] < 0 || next[0] >= height || next[1] < 0 || next[1] >= width || isVisited[next[0]][next[1]]) continue;
                    isVisited[next[0]][next[1]] = true;
                    if (field[next[0]][next[1]] == 0) que.offer(next);
                    if (field[next[0]][next[1]] == 1) isMelt.offer(next);
                }
            }

            if (isMelt.isEmpty()) break;
            last = isMelt.size();

            while (!isMelt.isEmpty()) {
                int[] melt = isMelt.poll();
                field[melt[0]][melt[1]] = 0;
            }
            turn++;
        }

        System.out.println(turn);
        System.out.println(last);

        br.close();
    }
}
