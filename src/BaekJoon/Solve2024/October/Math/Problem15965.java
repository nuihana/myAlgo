package BaekJoon.Solve2024.October.Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Problem15965 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int k = Integer.parseInt(br.readLine());
        boolean[] isPrime = new boolean[10000000];
        Arrays.fill(isPrime, true);
        int n = 1;
        for (int i = 2; i < 10000000; i++) {
            if (isPrime[i]) {
                if (n == k) {
                    System.out.print(i);
                    break;
                }
                n++;

                for (int j = 2; i * j < 10000000; j++) {
                    isPrime[i * j] = false;
                }
            }
        }

        br.close();
    }
}
