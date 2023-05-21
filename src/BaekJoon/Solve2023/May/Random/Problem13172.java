package BaekJoon.Solve2023.May.Random;

import java.io.*;
import java.util.StringTokenizer;

public class Problem13172 {
    final int MOD = 1000000007;
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int cnt = Integer.parseInt(br.readLine());
        long top = 1, bottom = 0;
        for (int i = 0; i < cnt; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());

            bottom = s * top + n * bottom;
            top *= n;

            top %= MOD;
            bottom %= MOD;
        }

        if (top % bottom != 0) {
            bw.write(String.valueOf(modInverse(top, MOD - 2) * bottom % MOD));
        } else {
            bw.write(String.valueOf(top / bottom));
        }

        br.close();
        bw.close();
    }

    private long modInverse(long N, int idx) {
        if (idx == 1) {
            return N;
        }
        long temp = modInverse(N, idx / 2);
        if (idx % 2 == 1) {
            return temp * temp % MOD * N % MOD;
        } else {
            return temp * temp % MOD;
        }
    }
}
