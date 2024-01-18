package BaekJoon.Solve2024.January.Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem2023 {
    int[] endPrimeNum = { 1, 3, 7, 9 };

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] startPrimeNum = { 2, 3, 5, 7 };
        for (int i = 0; i < 4; i++) {
            printPrime(n, new StringBuilder().append(startPrimeNum[i]));
        }

        br.close();
    }

    private void printPrime(int max, StringBuilder str) {
        if (max == str.toString().length()) {
            System.out.println(str);
            return;
        }

        for (int i = 0; i < 4; i++) {
            int cur = Integer.parseInt(str.toString() + endPrimeNum[i]);
            if (isPrime(cur)) {
                printPrime(max, str.append(endPrimeNum[i]));
                str.setLength(str.length() - 1);
            }
        }
    }

    private boolean isPrime(int num) {
        if (num == 1) return false;
        if (num <= 3) return true;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
}
