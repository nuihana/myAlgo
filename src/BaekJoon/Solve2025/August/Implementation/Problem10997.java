package BaekJoon.Solve2025.August.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem10997 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        if (n == 1) {
            sb.append("*");
        } else {
            int[][] arr = makeArr(n);
            for (int i = 0; i < arr.length; i++) {
                if (i == 1) {
                    sb.append("*").append("\n");
                    continue;
                }
                for (int j = 0; j < arr[i].length; j++) {
                    sb.append(arr[i][j] == 1 ? "*" : " ");
                }
                sb.append("\n");
            }
        }
        System.out.print(sb);

        br.close();
    }

    private int[][] makeArr(int n) {
        int[][] arr = new int[(n - 1) * 4 + 3][(n - 1) * 4 + 1];
        final int[] dr = { 0, 1, 0, -1 };
        final int[] dc = { -1, 0, 1, 0 };
        int r = 0, c = arr[0].length - 1;
        arr[r][c] = 1;

        while (true) {
            for (int i = 0; i < 4; i++) {
                int cnt = 0;
                while (true) {
                    if (r + dr[i] < 0 || r + dr[i] >= arr.length || c + dc[i] < 0 || c + dc[i] >= arr[0].length) break;
                    if (r + 2 * dr[i] >= 0 && r + 2 * dr[i] < arr.length && c + 2 * dc[i] >= 0 && c + 2 * dc[i] < arr[0].length && arr[r + 2 * dr[i]][c + 2 * dc[i]] == 1) break;
                    r += dr[i];
                    c += dc[i];
                    cnt++;
                    arr[r][c] = 1;
                }
                if (cnt == 0) return arr;
            }
        }
    }
}
