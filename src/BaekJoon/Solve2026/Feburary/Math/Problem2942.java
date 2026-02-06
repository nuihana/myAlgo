package BaekJoon.Solve2026.Feburary.Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem2942 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int gcd = GCD(Math.max(a, b), Math.min(a, b));

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i * i <= gcd; i++) {
            if (gcd % i == 0) {
                sb.append(i).append(" ").append(a / i).append(" ").append(b / i).append("\n");
                if (i * i != gcd) {
                    int j = gcd / i;
                    sb.append(j).append(" ").append(a / j).append(" ").append(b / j).append("\n");
                }
            }
        }
        System.out.print(sb);

        br.close();
    }

    private int GCD(int a, int b) {
        return b == 0 ? a : GCD(b, a % b);
    }
}
