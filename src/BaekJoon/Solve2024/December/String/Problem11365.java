package BaekJoon.Solve2024.December.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem11365 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        while (true) {
            String line = br.readLine();
            if ("END".equals(line)) break;

            for (int i = line.length() - 1; i >= 0; i--) {
                sb.append(line.charAt(i));
            }
            sb.append("\n");
        }
        System.out.print(sb);

        br.close();
    }
}
