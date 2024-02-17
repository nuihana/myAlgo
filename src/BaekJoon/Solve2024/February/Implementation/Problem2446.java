package BaekJoon.Solve2024.February.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem2446 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        int tmp = n;
        while (tmp-- > 1) {
            sb.append(" ".repeat(n - 1 - tmp));
            sb.append("*".repeat(tmp));
            sb.append("*");
            sb.append("*".repeat(tmp));
            sb.append("\n");
        }
        tmp--;
        while (tmp++ < n - 1) {
            sb.append(" ".repeat(n - 1 - tmp));
            sb.append("*".repeat(tmp));
            sb.append("*");
            sb.append("*".repeat(tmp));
            sb.append("\n");
        }

        System.out.print(sb);

        br.close();
    }
}
