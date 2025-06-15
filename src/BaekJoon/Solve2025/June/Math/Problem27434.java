package BaekJoon.Solve2025.June.Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Problem27434 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        if (n == 0) System.out.print(1);
        else System.out.print(factorial(1, n));

        br.close();
    }

    private BigInteger factorial(int start, int end) {
        if (start == end) return BigInteger.valueOf(end);
        return factorial(start, (start + end) / 2).multiply(factorial((start + end) / 2 + 1, end));
    }
}
