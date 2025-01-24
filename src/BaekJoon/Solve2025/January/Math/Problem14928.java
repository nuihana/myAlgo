package BaekJoon.Solve2025.January.Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Problem14928 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String val = br.readLine();
        long res = 0;
        for (int i = 0; i < val.length(); i++) {
            res = (res * 10 + (val.charAt(i) - '0')) % 20000303;
        }
        System.out.print(res);

        br.close();
    }
}
