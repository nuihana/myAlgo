package BaekJoon.Solve2023.April.Random;

import java.io.*;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Problem2407 {
    public void solution() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        String n = st.nextToken();
        String m = st.nextToken();

        bw.write(getComb(n, m).toString());

        br.close();
        bw.close();
    }

    private BigInteger getComb(String n, String m) {
        BigInteger result = new BigInteger(n);
        int numN = Integer.parseInt(n);
        int numM = Integer.parseInt(m);
        for (int num = numN - 1; num > numN - numM; num--) {
            result = result.multiply(BigInteger.valueOf(num));
        }

        return result.divide(new BigInteger(facto(numM)));
    }


    private String facto(int n) {
        BigInteger result = new BigInteger("1");
        for (int num = n; num > 1; num--) {
            result = result.multiply(BigInteger.valueOf(num));
        }

        return result.toString();
    }
}
