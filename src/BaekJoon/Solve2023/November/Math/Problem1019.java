package BaekJoon.Solve2023.November.Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem1019 {
    long[] ans = new long[10];

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long n = Long.parseLong(br.readLine());
        solve(1, n, 1);

        for (int i = 0; i < 10; i++) {
            System.out.print(ans[i] + " ");
        }

        br.close();
    }

    private void solve(long a, long b, long ten) {
        while (a % 10 != 0 && a <= b) {
            calc(a, ten);
            a++;
        }
        if (a > b) return;
        while (b % 10 != 9 && b >= a) {
            calc(b, ten);
            b--;
        }

        long cnt = (b / 10 - a / 10 + 1);
        for (int i = 0; i < 10; i++) {
            ans[i] += cnt * ten;
        }

        solve(a / 10, b / 10, ten * 10);
    }

    private void calc(long n, long ten) {
        while (n > 0) {
            ans[(int) (n % 10)] += ten;
            n /= 10;
        }
    }
}
