package BaekJoon.Solve2025.August.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem16507 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        int[][] bMap = new int[r][c];
        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0 ; j < c ; j++) {
                bMap[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] partSum = new int[r][c + 1];
        for (int i = 0; i < r; i++) {
            for (int j = 1; j <= c; j++) {
                partSum[i][j] = partSum[i][j - 1] + bMap[i][j - 1];
            }
        }

        StringBuilder sb = new StringBuilder();
        while (q-- > 0) {
            st = new StringTokenizer(br.readLine());
            int r1 = Integer.parseInt(st.nextToken());
            int c1 = Integer.parseInt(st.nextToken());
            int r2 = Integer.parseInt(st.nextToken());
            int c2 = Integer.parseInt(st.nextToken());

            sb.append(avg(r1 - 1, c1, r2 - 1, c2, partSum)).append("\n");
        }
        System.out.print(sb);

        br.close();
    }

    private int avg(int r1, int c1, int r2, int c2, int[][] map) {
        int sum = 0;
        int cnt = 0;
        for (int i = r1; i <= r2; i++) {
            sum += map[i][c2] - map[i][c1 - 1];
            cnt += c2 - c1 + 1;
        }
        return sum / cnt;
    }
}
