package BaekJoon.Solve2025.June.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem1837 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        BigInteger p = new BigInteger(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        boolean[] isPrime = new boolean[k + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;
        for (int i = 2; i <= k; i++) {
            if (isPrime[i]) {
                for (int j = 2; i * j <= k; j++) {
                    isPrime[i * j] = false;
                }
            }
        }

        for (int i = 2; i < k; i++) {
            if (isPrime[i]) {
                if (p.mod(new BigInteger(String.valueOf(i))).equals(BigInteger.ZERO)) {
                    System.out.print("BAD " + i);
                    return;
                }
            }
        }
        System.out.print("GOOD");

        br.close();
    }
}
