package BaekJoon.Solve2025.June.Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem5618 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        n -= 2;

        int res = GCD(Math.max(a, b), Math.min(a, b));
        if (n > 0) {
            int c = Integer.parseInt(st.nextToken());
            res = GCD(Math.max(res, c), Math.min(res, c));
        }

        for (int i = 1; i <= res; i++) {
            if (res % i == 0) {
                System.out.println(i);
            }
        }

        br.close();
    }

    private int GCD(int a, int b) {
        if (b == 0) return a;
        return GCD(b, a % b);
    }
}
