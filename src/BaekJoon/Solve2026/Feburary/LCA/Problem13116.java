package BaekJoon.Solve2026.Feburary.LCA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem13116 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (n-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            sb.append(find(a, b)).append("\n");
        }
        System.out.print(sb);

        br.close();
    }

    private int find(int a, int b) {
        int min = Math.min(a, b);

        if (min == a) {
            while (true) {
                if (b - a < a) break;
                b /= 2;
            }
        } else {
            while (true) {
                if (a - b < b) break;
                a /= 2;
            }
        }

        while (a != b) {
            if (a > b) {
                a /= 2;
                if (a == b) break;
                b /= 2;
            } else {
                b /= 2;
                if (a == b) break;
                a /= 2;
            }
        }

        return a * 10;
    }
}
