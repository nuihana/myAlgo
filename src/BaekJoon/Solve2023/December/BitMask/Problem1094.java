package BaekJoon.Solve2023.December.BitMask;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem1094 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());
        int result = 0;
        int bit = 1;
        while (bit <= 64) {
            if ((num & bit) > 0) result++;
            bit <<= 1;
        }
        System.out.println(result);

        br.close();
    }
}
