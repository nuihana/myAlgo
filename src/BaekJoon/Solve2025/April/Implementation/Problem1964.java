package BaekJoon.Solve2025.April.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem1964 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int res = 5;
        int lev = 1;
        final int MOD = 45678;

        while (lev++ < n) {
            res = (res + (lev * 3 + 1)) % MOD;
        }
        System.out.print(res);

        br.close();
    }
}
