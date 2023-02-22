package BaekJoon.Solve2023.DivideAndConquer;

import java.io.*;
import java.util.StringTokenizer;

public class Problem11401 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int m = 1000000007;

        int upper = 1;

        for (int i = n, iLimit = n - k; i > iLimit; i--) {
            upper = (upper * i) % m;
        }

        int lower = 1;

        for (int i = 2; i <= k; i++) {
            lower = (lower * i) % m;
        }

        bw.write(Long.toString((upper * mod_exp(lower, m - 2, m)) % m));

        br.close();
        bw.close();
    }

    private long mod_exp(int a, int b, int mod) {
        long result = -1;

        int[] binaryB = new int[32];
        int maximumB = 0;

        for (int i = 0; b != 1; i++) {
            binaryB[i] = b % 2;
            b = b / 2;
            maximumB = i + 1;
        }
        binaryB[maximumB] = b;

        long[] sqrModulerC = new long[maximumB + 1];
        sqrModulerC[0] = a % mod;
        for (int i = 1; i <= maximumB; i++) {
            sqrModulerC[i] = (sqrModulerC[i - 1] * sqrModulerC[i - 1]) % mod;
        }

        for (int i = 0; i < maximumB + 1; i++) {
            if(binaryB[i] > 0) {
                if (result < 0) {
                    result = sqrModulerC[i];
                } else {
                    result = ((result % mod) * (sqrModulerC[i] % mod)) % mod;
                }
            }
        }

        return result;
    }
}
