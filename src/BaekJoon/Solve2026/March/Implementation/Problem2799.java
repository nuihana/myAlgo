package BaekJoon.Solve2026.March.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem2799 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        char[][] window = new char[r * 5 + 1][c * 5 + 1];
        for (int i = 0; i <= r * 5; i++) {
            String line = br.readLine();
            for (int j = 0; j <= c * 5; j++) {
                window[i][j] = line.charAt(j);
            }
        }

        int[] res = new int[5];
        for (int i = 0; i < r; i++) {
            int sr = i * 5 + 1;
            for (int j = 0; j < c; j++) {
                int sc = j * 5 + 1;
                int cnt = 0;
                for (int k = 0; k < 5; k++) {
                    if (window[sr + k][sc] == '*') cnt++;
                }

                res[cnt]++;
            }
        }

        for (int i = 0; i < 5; i++) {
            System.out.print(res[i] + " ");
        }

        br.close();
    }
}
