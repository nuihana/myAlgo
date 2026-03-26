package BaekJoon.Solve2026.March.BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem1895 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int[][] img = new int[r][c];
        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < c; j++) {
                img[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[] dr = { -1, -1, -1, 0, 0, 0, 1, 1, 1 };
        int[] dc = { -1, 0, 1, -1, 0, 1, -1, 0, 1 };
        int t = Integer.parseInt(br.readLine());
        int res = 0;
        for (int i = 1; i < r - 1; i++) {
            for (int j = 1; j < c - 1; j++) {
                int[] arr = new int[9];
                for (int k = 0; k < 9; k++) {
                    arr[k] = img[i + dr[k]][j + dc[k]];
                }
                Arrays.sort(arr);

                if (arr[4] >= t) res++;
            }
        }
        System.out.print(res);

        br.close();
    }
}
