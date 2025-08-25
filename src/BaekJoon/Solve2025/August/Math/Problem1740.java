package BaekJoon.Solve2025.August.Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Problem1740 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        BigInteger res = new BigInteger("0");
        long n = Long.parseLong(br.readLine());
        int idx = 0;
        while (n > 0) {
            long mod = n % 2;
            BigInteger tmp = new BigInteger("3");
            if (mod == 1) {
                tmp = tmp.pow(idx);
                res = res.add(tmp);
            }
            n /= 2;
            idx++;
        }
        System.out.print(res);

        br.close();
    }
}
