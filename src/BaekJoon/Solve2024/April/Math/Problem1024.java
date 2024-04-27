package BaekJoon.Solve2024.April.Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem1024 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int pur = Integer.parseInt(st.nextToken());
        int len = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();
        for (int i = len; i <= 100; i++) {
            int x = pur - (i * (i + 1)) / 2;

            if (x % i == 0) {
                x = x / i;

                if (x >= -1) {
                    for (int j = 1; j <= i; j++) {
                        sb.append(x + j).append(" ");
                    }

                    break;
                }
            }
        }

        if (sb.length() == 0) {
            sb.append("-1");
        }
        System.out.print(sb);

        br.close();
    }
}
