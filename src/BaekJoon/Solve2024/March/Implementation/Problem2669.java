package BaekJoon.Solve2024.March.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem2669 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[][] field = new int[100][100];
        for (int i = 0; i < 4; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int lbx = Integer.parseInt(st.nextToken());
            int lby = Integer.parseInt(st.nextToken());
            int rtx = Integer.parseInt(st.nextToken());
            int rty = Integer.parseInt(st.nextToken());

            for (int y = lby; y < rty; y++) {
                for (int x = lbx; x < rtx; x++) {
                    field[x][y] = 1;
                }
            }
        }

        int res = 0;
        for (int i = 1; i < 100; i++) {
            for (int j = 1; j < 100; j++) {
                if (field[i][j] == 1) res++;
            }
        }

        System.out.print(res);

        br.close();
    }
}
