package BaekJoon.Solve2024.June.BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem1058 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[][] relation = new int[n][n];

        for (int i = 0; i < n; i++) {
            String src = br.readLine();
            for (int j = 0; j < n; j++) {
                if (src.charAt(j) == 'Y') {
                    relation[i][j] = 1;
                }
            }
        }

        int res = 0;
        for (int i = 0; i < n; i++) {
            boolean[] isFriend = new boolean[n];

            for (int j = 0; j < n; j++) {
                if (relation[i][j] > 0) {
                    isFriend[j] = true;

                    for (int k = 0; k < n; k++) {
                        if (relation[j][k] > 0) {
                            isFriend[k] = true;
                        }
                    }
                }
            }

            int now = 0;
            for (int j = 0; j < n; j++) {
                if (isFriend[j] && j != i) now++;
            }

            res = Math.max(res, now);
        }

        System.out.print(res);

        br.close();
    }
}
