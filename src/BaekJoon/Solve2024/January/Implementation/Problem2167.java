package BaekJoon.Solve2024.January.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem2167 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int height = Integer.parseInt(st.nextToken());
        int width = Integer.parseInt(st.nextToken());

        int[][] sum = new int[height][width + 1];
        for (int i = 0; i < height; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= width; j++) {
                sum[i][j] = sum[i][j - 1] + Integer.parseInt(st.nextToken());
            }
        }

        int caseCnt = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (caseCnt-- > 0) {
            st = new StringTokenizer(br.readLine());
            int sx = Integer.parseInt(st.nextToken()) - 1;
            int sy = Integer.parseInt(st.nextToken());
            int ex = Integer.parseInt(st.nextToken()) - 1;
            int ey = Integer.parseInt(st.nextToken());

            int result = 0;
            for (int i = sx; i < ex; i++) {
                result += sum[i][ey] - sum[i][sy];
            }

            sb.append(result).append("\n");
        }

        System.out.print(sb);

        br.close();
    }
}
