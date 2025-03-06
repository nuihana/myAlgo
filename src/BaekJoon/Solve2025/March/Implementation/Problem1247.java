package BaekJoon.Solve2025.March.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Problem1247 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            int n = Integer.parseInt(br.readLine());

            BigInteger res = new BigInteger("0");

            for (int j = 0; j < n; j++) {
                res = res.add(new BigInteger(br.readLine()));
            }

            if (res.compareTo(BigInteger.ZERO) == 0) {
                sb.append("0").append("\n");
            } else if (res.compareTo(BigInteger.ZERO) > 0) {
                sb.append("+").append("\n");
            } else {
                sb.append("-").append("\n");
            }
        }
        System.out.print(sb);

        br.close();
    }
}
