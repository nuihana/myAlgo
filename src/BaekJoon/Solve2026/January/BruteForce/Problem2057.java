package BaekJoon.Solve2026.January.BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;

public class Problem2057 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long n = Long.parseLong(br.readLine());
        long[] factorial = new long[21];

        if (n == 0) {
            System.out.print("NO");
            return;
        }

        factorial[0] = 1;
        for (int i = 1; i <= 20; i++) {
            factorial[i] = factorial[i - 1] * i;
        }

        for (int i = 20; i >= 0; i--) {
            if (n >= factorial[i]) n -= factorial[i];
        }

        if (n == 0) {
            System.out.print("YES");
        } else {
            System.out.print("NO");
        }

        br.close();
    }
}
