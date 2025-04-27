package BaekJoon.Solve2025.April.Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem2702 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            int gcd = GCD(Math.max(a, b), Math.min(a, b));
            sb.append(a * b / gcd).append(" ").append(gcd).append("\n");
        }
        System.out.print(sb);

        br.close();
    }

    private int GCD(int a, int b) {
        return a % b == 0 ? b : GCD(b, a % b);
    }
}
