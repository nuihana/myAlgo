package BaekJoon.Solve2026.January.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem6378 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        while (true) {
            String src = br.readLine();
            if ("0".equals(src)) break;

            while (src.length() > 1) {
                int sum = 0;
                for (int i = 0; i < src.length(); i++) {
                    sum += src.charAt(i) - '0';
                }

                src = String.valueOf(sum);
            }

            sb.append(src).append("\n");
        }
        System.out.print(sb);

        br.close();
    }
}
