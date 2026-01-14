package BaekJoon.Solve2026.January.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem1871 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (n-- > 0) {
            String src = br.readLine();

            int left = 0;
            for (int i = 0; i < 3; i++) {
                int val = src.charAt(i) - 'A';
                left += val * Math.pow(26, 2 - i);
            }

            int right = Integer.parseInt(src.substring(src.length() - 4));

            if (Math.abs(right - left) <= 100) {
                sb.append("nice").append("\n");
            } else {
                sb.append("not nice").append("\n");
            }
        }
        System.out.print(sb);

        br.close();
    }
}
