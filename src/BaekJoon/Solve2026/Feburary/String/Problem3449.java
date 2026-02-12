package BaekJoon.Solve2026.Feburary.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem3449 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (n-- > 0) {
            String a = br.readLine();
            String b = br.readLine();

            int cnt = 0;
            for (int i = 0; i < a.length(); i++) if (a.charAt(i) != b.charAt(i)) cnt++;

            sb.append("Hamming distance is ").append(cnt).append(".\n");
        }
        System.out.print(sb);

        br.close();
    }
}
