package BaekJoon.Solve2025.September.Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem1564 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        long res = 1;
        final long MOD = (long) 1e12;
        for (int i = 1; i <= n; i++) {
            res *= i;
            while (res % 10 == 0) res /= 10;

            res %= MOD;
        }

        String str = String.valueOf(res);
        System.out.print(str.substring(str.length() - 5));

        br.close();
    }
}
