package BaekJoon.Solve2024.December.Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem10837 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int k = Integer.parseInt(br.readLine());
        int c = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (c-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());

            if (m == n) {
                sb.append("1").append("\n");
            } else if (m < n) {
                sb.append(k + m - 2 * (n - 1) > 0 ? "1" : "0").append("\n");
            } else {
                sb.append(k - 2 * (m - 1) + n + 1 > 0 ? "1" : "0").append("\n");
            }
        }
        System.out.print(sb);

        br.close();
    }
}
