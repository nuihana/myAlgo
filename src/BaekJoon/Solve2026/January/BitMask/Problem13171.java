package BaekJoon.Solve2026.January.BitMask;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem13171 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long a = Long.parseLong(br.readLine());
        long x = Long.parseLong(br.readLine());
        final int MOD = (int) 1e9 + 7;

        long[] cache = new long[64];
        cache[0] = a % MOD;
        for (int i = 1; i < 64; i++) {
            cache[i] = (cache[i - 1] * cache[i - 1]) % MOD;
        }

        long res = 1;
        for (int i = 63; i >= 0; i--) {
            if ((x & (1L << i)) != 0) {
                res = res * cache[i] % MOD;
            }
        }

        System.out.print(res);

        br.close();
    }
}
