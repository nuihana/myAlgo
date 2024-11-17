package BaekJoon.Solve2024.November.Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;

public class Problem1373 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        while (input.length() % 3 != 0) {
            input = "0".concat(input);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < input.length() / 3; i++) {
            String src = input.substring(i * 3, i * 3 + 3);

            int tmp = 0;
            for (int j = 0, mul = 4; j < 3; j++) {
                if (src.charAt(j) == '1') {
                    tmp += mul;
                }
                mul /= 2;
            }

            sb.append(tmp);
        }
        System.out.print(sb);

        br.close();
    }
}
