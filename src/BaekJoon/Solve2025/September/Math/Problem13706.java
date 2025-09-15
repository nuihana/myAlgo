package BaekJoon.Solve2025.September.Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Problem13706 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        BigInteger src = new BigInteger(br.readLine());
        System.out.print(src.sqrt());

        br.close();
    }
}
