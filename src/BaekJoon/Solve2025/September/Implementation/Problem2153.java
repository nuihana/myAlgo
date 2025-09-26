package BaekJoon.Solve2025.September.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem2153 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String src = br.readLine();

        int sum = 0;
        for (int i = 0; i < src.length(); i++) {
            char c = src.charAt(i);

            if (c >= 'a' && c <= 'z') {
                sum += c - 'a' + 1;
            } else {
                sum += c - 'A' + 27;
            }
        }

        boolean isPrime = true;
        for (int i = 2; i <= sum / 2 && isPrime; i++) {
            if (sum % i == 0) isPrime = false;
        }

        if (isPrime) {
            System.out.print("It is a prime word.");
        } else {
            System.out.print("It is not a prime word.");
        }

        br.close();
    }
}
