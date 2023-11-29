package BaekJoon.Solve2023.November.Random;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem3055 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int row = Integer.parseInt(st.nextToken());
        int col = Integer.parseInt(st.nextToken());

        char[][] field = new char[row][col];
        Queue<int[]> water = new LinkedList<>();
        Queue<int[]> hedge = new LinkedList<>();
        for (int i = 0; i < row; i++) {
            String line = br.readLine();
            for (int j = 0; j < col; j++) {
                char c = line.charAt(j);
                field[i][j] = c;
                if (c == '*') water.add(new int[]{ i, j });
                if (c == 'S') hedge.add(new int[]{ i, j, 0 });
            }
        }

        int[] dr = { -1, 0, 1, 0 };
        int[] dc = { 0, 1, 0, -1 };
        int res = -1;
        while (!hedge.isEmpty()) {
            int len = water.size();
            while (len-- > 0) {
                int[] now = water.poll();
                for (int i = 0; i < 4; i++) {
                    int[] next = { now[0] + dr[i], now[1] + dc[i] };
                    if (next[0] < 0 || next[1] < 0 || next[0] >= row || next[1] >= col) continue;
                    if (field[next[0]][next[1]] == '.') {
                        field[next[0]][next[1]] = '*';
                        water.offer(next);
                    }
                }
            }

            len = hedge.size();
            while (len-- > 0) {
                int[] now = hedge.poll();
                for (int i = 0; i < 4; i++) {
                    int[] next = { now[0] + dr[i], now[1] + dc[i], now[2] + 1 };
                    if (next[0] < 0 || next[1] < 0 || next[0] >= row || next[1] >= col) continue;
                    if (field[next[0]][next[1]] == 'D') {
                        res = next[2];
                        break;
                    } else if (field[next[0]][next[1]] == '.') {
                        field[next[0]][next[1]] = 'S';
                        hedge.offer(next);
                    }
                }
            }

            if (res != -1) break;
        }

        System.out.println(res == -1 ? "KAKTUS" : res);

        br.close();
    }
}
