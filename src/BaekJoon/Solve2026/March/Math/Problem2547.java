package BaekJoon.Solve2026.March.Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem2547 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            br.readLine();
            int n = Integer.parseInt(br.readLine());
            long sum = 0;
            for (int i = 0; i < n; i++) {
                sum += Long.parseLong(br.readLine());
                sum %= n;
            }

            if (sum == 0) sb.append("YES").append("\n");
            else sb.append("NO").append("\n");
        }
        System.out.print(sb);

        br.close();
    }
}
