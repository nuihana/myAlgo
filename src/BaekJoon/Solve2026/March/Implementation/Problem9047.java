package BaekJoon.Solve2026.March.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Problem9047 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            int src = Integer.parseInt(br.readLine());

            int cnt = 0;
            while (src != 6174) {
                int[] digits = new int[4];
                for (int i = 0; i < 4; i++) {
                    digits[i] = src % 10;
                    src /= 10;
                }
                Arrays.sort(digits);

                int min = 0, max = 0;
                for (int i = 0; i < 4; i++) {
                    min = min * 10 + digits[i];
                    max = max * 10 + digits[3 - i];
                }

                src = max - min;
                cnt++;
            }
            sb.append(cnt).append("\n");
        }
        System.out.print(sb);

        br.close();
    }
}
