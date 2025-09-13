package BaekJoon.Solve2025.September.Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem14626 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String src = br.readLine();
        int[] mul = { 1, 3, 1, 3, 1, 3, 1, 3, 1, 3, 1, 3, 1 };
        int idx = -1;

        int sum = 0;
        for (int i = 0; i < src.length(); i++) {
            if (src.charAt(i) == '*') {
                idx = i;
            } else {
                sum += (src.charAt(i) - '0') * mul[i];
            }
        }

        for (int i = 0; i <= 9; i++) {
            if ((sum + i * mul[idx]) % 10 == 0) {
                System.out.print(i);
                break;
            }
        }

        br.close();
    }
}
