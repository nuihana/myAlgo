package BaekJoon.Solve2025.Feburary.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem4458 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (n-- > 0) {
            String line = br.readLine();
            sb.append(line.substring(0, 1).toUpperCase()).append(line.substring(1)).append("\n");
        }
        System.out.print(sb);

        br.close();
    }
}
