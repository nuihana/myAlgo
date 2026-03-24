package BaekJoon.Solve2026.March.BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem9471 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int p = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (p-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            int a = 1, b = 1, cnt = 0;
            while (true) {
                int next = (a + b) % m;
                a = b;
                b = next;
                cnt++;

                if (a == 1 && b == 1) break;
            }

            sb.append(n).append(" ").append(cnt).append("\n");
        }
        System.out.print(sb);

        br.close();
    }
}
