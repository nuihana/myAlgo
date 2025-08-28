package BaekJoon.Solve2025.August.Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem10166 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int d1 = Integer.parseInt(st.nextToken());
        int d2 = Integer.parseInt(st.nextToken());

        int res = 0;
        boolean[][] map = new boolean[d2 + 1][d2 + 1];
        for (int i = d1; i <= d2; i++) {
            for (int j = 1; j <= i; j++) {
                int gcd = GCD(i, j);
                int a = j / gcd;
                int b = i / gcd;
                if (!map[a][b]) {
                    map[a][b] = true;
                    res++;
                }
            }
        }
        System.out.print(res);

        br.close();
    }

    private int GCD(int a, int b) {
        if (b == 0) return a;
        return GCD(b, a % b);
    }
}
