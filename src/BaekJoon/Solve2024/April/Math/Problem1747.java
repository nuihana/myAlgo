package BaekJoon.Solve2024.April.Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Problem1747 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int len = 10000000;
        int n = Integer.parseInt(br.readLine());
        boolean[] isPrime = new boolean[len];
        Arrays.fill(isPrime, true);

        int num = 2;
        while (true) {
            if (isPrime[num]) {
                for (int i = 2; i * num < len; i++) {
                    isPrime[i * num] = false;
                }

                if (isPalindrome(num) && num >= n) break;
            }

            num++;
        }

        System.out.print(num);

        br.close();
    }

    private boolean isPalindrome(int num) {
        String str = String.valueOf(num);

        int l = 0;
        int r = str.length() - 1;

        while (l < r) {
            if (str.charAt(l) != str.charAt(r)) return false;
            l++;
            r--;
        }

        return true;
    }
}
