package BaekJoon.Solve2024.May.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem1913 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int size = Integer.parseInt(br.readLine());
        int num = Integer.parseInt(br.readLine());

        int[][] field = new int[size][size];

        int idx = 1, len = 1;
        int x = size / 2;
        int y = size / 2;
        field[x][y] = idx++;
        int[] res = { x, y };
        while (idx <= size * size) {
            if (len % 2 == 0) { // 하, 좌
                for (int i = 0; i < len; i++) {
                    field[++x][y] = idx;
                    if (idx == num) {
                        res[0] = x;
                        res[1] = y;
                    }
                    idx++;
                }
                for (int i = 0; i < len; i++) {
                    field[x][--y] = idx;
                    if (idx == num) {
                        res[0] = x;
                        res[1] = y;
                    }
                    idx++;
                }
            } else { // 상, 우
                for (int i = 0; i < len; i++) {
                    if (idx > size * size) break;
                    field[--x][y] = idx;
                    if (idx == num) {
                        res[0] = x;
                        res[1] = y;
                    }
                    idx++;
                }
                for (int i = 0; i < len; i++) {
                    if (idx > size * size) break;
                    field[x][++y] = idx;
                    if (idx == num) {
                        res[0] = x;
                        res[1] = y;
                    }
                    idx++;
                }
            }
            len++;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                sb.append(field[i][j]).append(" ");
            }
            sb.append("\n");
        }

        sb.append(res[0] + 1).append(" ").append(res[1] + 1);
        System.out.print(sb);

        br.close();
    }
}
