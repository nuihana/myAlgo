package BaekJoon.Solve2025.October.Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem2725 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] cnt = new int[1001];
        cnt[1] = 3;
        for (int i = 2; i < 1001; i++) {
            int tmp = 0;
            for (int j = 1; j < i; j++) {
                if (GCD(i, j) == 1) tmp++;
            }
            cnt[i] = cnt[i - 1] + tmp * 2;
        }

        int c = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < c; i++) {
            sb.append(cnt[Integer.parseInt(br.readLine())]).append("\n");
        }
        System.out.print(sb);

        br.close();
    }

    private int GCD(int a, int b) {
        if (b == 0) return a;
        return GCD(b, a % b);
    }
}
