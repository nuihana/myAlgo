package BaekJoon.Solve2026.March.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem2890 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        char[][] map = new char[r][c];
        int[] loc = new int[10];
        for (int i = 0; i < r; i++) {
            String line = br.readLine();
            for (int j = 0; j < c; j++) {
                map[i][j] = line.charAt(j);
                if (map[i][j] >= '1' && map[i][j] <= '9') {
                    loc[map[i][j] - '0'] = j;
                }
            }
        }

        int[] rank = new int[10];
        int nth = 1;
        for (int i = c - 1; i > 0; i--) {
            boolean chk = false;
            for (int j = 1; j <= 9; j++) {
                if (loc[j] == i) {
                    chk = true;
                    rank[j] = nth;
                }
            }
            if (chk) nth++;
        }

        for (int i = 1; i <= 9; i++) {
            System.out.println(rank[i]);
        }

        br.close();
    }
}
