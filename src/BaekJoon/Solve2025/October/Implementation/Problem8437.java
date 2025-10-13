package BaekJoon.Solve2025.October.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Problem8437 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        BigInteger total = new BigInteger(br.readLine());
        BigInteger diff = new BigInteger(br.readLine());

        if (total.mod(BigInteger.TWO).equals(BigInteger.ZERO)) {
            System.out.println(total.divide(BigInteger.TWO).add(diff.divide(BigInteger.TWO)));
            System.out.print(total.divide(BigInteger.TWO).subtract(diff.divide(BigInteger.TWO)));
        } else {
            System.out.println(total.divide(BigInteger.TWO).add(diff.divide(BigInteger.TWO).add(BigInteger.ONE)));
            System.out.print(total.divide(BigInteger.TWO).subtract(diff.divide(BigInteger.TWO)));
        }

        br.close();
    }
}
