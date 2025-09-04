package BaekJoon.Solve2025.September.Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Problem2824 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        BigInteger a = new BigInteger("1");
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a = a.multiply(BigInteger.valueOf(Integer.parseInt(st.nextToken())));
        }

        int m = Integer.parseInt(br.readLine());
        BigInteger b = new BigInteger("1");
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            b = b.multiply(BigInteger.valueOf(Integer.parseInt(st.nextToken())));
        }

        BigInteger res = GCD(a, b);
        String str = res.toString();
        System.out.print(str.length() > 9 ? str.substring(str.length() - 9) : str);

        br.close();
    }

    private BigInteger GCD(BigInteger a, BigInteger b) {
        if (a.compareTo(b) > 0) {
            if (a.mod(b).equals(BigInteger.ZERO)) {
                return b;
            }
            return GCD(b, a.mod(b));
        } else if (a.compareTo(b) < 0) {
            if (b.mod(a).equals(BigInteger.ZERO)) {
                return a;
            }
            return GCD(a, b.mod(a));
        }
        return a;
    }
}
