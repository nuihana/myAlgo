package BaekJoon.Solve2026.Feburary.Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem1731 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int n1 = Integer.parseInt(br.readLine());
        int n2 = Integer.parseInt(br.readLine());
        int n3 = Integer.parseInt(br.readLine());

        boolean flag = true; // true : 등차, false : 등비
        if (n2 % n1 == 0) {
            int dm = n2 / n1;
            if (n2 * dm == n3) flag = false;
        }

        for (int i = 3; i < n; i++) {
            n3 = Integer.parseInt(br.readLine());
        }

        System.out.print(flag ? n3 + (n2 - n1) : n3 * (n2 / n1));

        br.close();
    }
}
