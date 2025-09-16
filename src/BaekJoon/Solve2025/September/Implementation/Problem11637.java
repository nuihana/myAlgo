package BaekJoon.Solve2025.September.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem11637 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());

            int sum = 0;
            int max = Integer.MIN_VALUE, win = 0;
            for (int i = 1; i <= n; i++) {
                int cnt = Integer.parseInt(br.readLine());

                sum += cnt;
                if (cnt > max) {
                    max = cnt;
                    win = i;
                } else if (cnt == max) {
                    win = -1;
                }
            }

            if (win != -1) {
                if (sum / 2 < max) {
                    sb.append("majority winner ").append(win);
                } else {
                    sb.append("minority winner ").append(win);
                }
            } else {
                sb.append("no winner");
            }
            sb.append("\n");
        }
        System.out.print(sb);

        br.close();
    }
}
