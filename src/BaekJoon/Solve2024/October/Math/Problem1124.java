package BaekJoon.Solve2024.October.Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem1124 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        boolean[] isPrime = new boolean[100001];
        int[] count = new int[100001];
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;
        for (int i = 2; i <= 100000; i++) {
            if (isPrime[i]) {
                int j = 2;
                while (i * j <= 100000) {
                    isPrime[i * j] = false;
                    int tmp = i * j;
                    while (tmp % i == 0) {
                        tmp /= i;
                        count[i * j]++;
                    }
                    j++;
                }
            }
        }

        int res = 0;
        for (int i = a; i <= b; i++) {
            if (isPrime[count[i]]) res++;
        }

        System.out.print(res);

        br.close();
    }
}
