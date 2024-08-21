package BaekJoon.Solve2024.August.Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem3474 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (n-- > 0) {
            int val = Integer.parseInt(br.readLine());
            sb.append(findFive(val)).append("\n");
        }
        System.out.print(sb);

        br.close();
    }

    private int findFive(int n) {
        int t = 5;
        int res = 0;
        while (t <= n) {
            res += n / t;
            t *= 5;
        }
        return res;
    }
}
