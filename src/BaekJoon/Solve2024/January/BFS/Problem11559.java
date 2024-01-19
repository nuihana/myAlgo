package BaekJoon.Solve2024.January.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Problem11559 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[][] field = new char[12][6];
        for (int i = 0; i < 12; i++) {
            String block = br.readLine();

            for (int j = 0; j < 6; j++) {
                field[i][j] = block.charAt(j);
            }
        }

        Queue<int[]> que = new LinkedList<>();
        int[] dx = { -1, 0, 1, 0 };
        int[] dy = { 0, 1, 0, -1 };
        int series = 0;
        while (true) {
            // 반응
            boolean isExplode = false;
            for (int i = 0; i < 12; i++) {
                for (int j = 0; j < 6; j++) {
                    if (field[i][j] != '.') {
                        boolean[][] isVisited = new boolean[12][6];
                        que.offer(new int[]{ i, j });
                        isVisited[i][j] = true;
                        char c = field[i][j];
                        int amount = 0;

                        while (!que.isEmpty()) {
                            int[] now = que.poll();
                            amount++;

                            for (int k = 0; k < 4; k++) {
                                int nx = now[0] + dx[k];
                                int ny = now[1] + dy[k];
                                if (nx < 0 || nx >= 12 || ny < 0 || ny >= 6 || field[nx][ny] != c || isVisited[nx][ny]) continue;
                                que.offer(new int[]{ nx, ny });
                                isVisited[nx][ny] = true;
                            }
                        }

                        if (amount >= 4) {
                            isExplode = true;
                            for (int x = 0; x < 12; x++) {
                                for (int y = 0; y < 6; y++) {
                                    if (isVisited[x][y]) field[x][y] = '.';
                                }
                            }
                        }
                    }
                }
            }

            if (!isExplode) break;
            series++;
            // 블록 내려옴
            for (int y = 0; y < 6; y++) {
                boolean noBlock = false;
                for (int x = 11; x >= 0 && !noBlock; x--) {
                    if (field[x][y] == '.') {
                        noBlock = true;
                        for (int d = x - 1; d >= 0; d--) {
                            if (field[d][y] != '.') {
                                field[x][y] = field[d][y];
                                field[d][y] = '.';
                                noBlock = false;
                                break;
                            }
                        }
                    }
                }
            }
        }

        System.out.print(series);

        br.close();
    }
}
