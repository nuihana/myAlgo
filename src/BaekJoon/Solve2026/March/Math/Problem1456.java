package BaekJoon.Solve2026.March.Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Problem1456 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());

        int max = (int)Math.sqrt(b) + 1;
        boolean[] isPrime = new boolean[max];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;
        for (int i = 2; i * i < max; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j < max; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        int res = 0;
        for (int i = 2; i < max; i++) {
            if (!isPrime[i]) continue;
            long tmp = (long)i * (long)i;
            while (tmp <= b) {
                if (tmp >= a) res++;
                if (tmp > b / i) break;
                tmp *= i;
            }
        }
        System.out.print(res);

        br.close();
    }
}
