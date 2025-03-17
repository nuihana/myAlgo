package BaekJoon.Solve2025.March.Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Problem1834 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        BigInteger res = new BigInteger("0");
        long n = Long.parseLong(br.readLine());

        for (int i = 1; i < n; i++) {
            res = res.add(new BigInteger(String.valueOf(n * i + i)));
        }

        System.out.print(res);

        br.close();
    }
}
