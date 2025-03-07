package BaekJoon.Solve2025.March.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Problem5988 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (n-- > 0) {
            BigInteger k = new BigInteger(br.readLine());
            if (k.mod(BigInteger.TWO).equals(BigInteger.ZERO)) {
                sb.append("even").append("\n");
            } else {
                sb.append("odd").append("\n");
            }
        }
        System.out.print(sb);

        br.close();
    }
}
