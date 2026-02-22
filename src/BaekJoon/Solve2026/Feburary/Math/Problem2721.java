package BaekJoon.Solve2026.Feburary.Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem2721 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int res = 0;
            for (int i = 1; i <= n; i++) {
                res += i * TriNum(i + 1);
            }
            sb.append(res).append("\n");
        }
        System.out.print(sb);

        br.close();
    }

    private int TriNum(int n) {
        int res = 0;

        if (n % 2 == 0) {
            res = (1 + n) * (n / 2);
        } else {
            res = (1 + n) * (n / 2) + (n / 2 + 1);
        }

        return res;
    }
}
