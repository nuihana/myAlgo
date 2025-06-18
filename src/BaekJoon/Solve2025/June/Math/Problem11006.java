package BaekJoon.Solve2025.June.Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem11006 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            for (int u = 0; u <= m; u++) {
                if (u * 1 + (m - u) * 2 == n) {
                    sb.append(u).append(" ").append(m - u).append("\n");
                    break;
                }
            }
        }
        System.out.print(sb);

        br.close();
    }
}
