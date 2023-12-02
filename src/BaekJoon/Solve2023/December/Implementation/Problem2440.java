package BaekJoon.Solve2023.December.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem2440 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (n-- > 0) {
            for (int i = 0; i <= n; i++) {
                sb.append("*");
            }
            sb.append("\n");
        }

        System.out.print(sb);

        br.close();
    }
}
