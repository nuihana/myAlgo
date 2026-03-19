package BaekJoon.Solve2026.March.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem21314 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String src = br.readLine();

        StringBuilder sb = new StringBuilder();
        for (int i = 0, cnt = 0; i < src.length(); i++) {
            if (src.charAt(i) == 'M') {
                cnt++;
            } else {
                sb.append("5").append("0".repeat(cnt));
                cnt = 0;
            }

            if (i == src.length() - 1 && cnt != 0) {
                sb.append("1".repeat(cnt));
            }
        }

        System.out.println(sb);

        sb = new StringBuilder();
        for (int i = 0, cnt = 0; i < src.length(); i++) {
            if (src.charAt(i) == 'M') {
                cnt++;
            } else {
                if (cnt > 0) {
                    sb.append("1").append("0".repeat(cnt - 1));
                    cnt = 0;
                }
                sb.append("5");
            }

            if (i == src.length() - 1 && cnt != 0) {
                sb.append("1").append("0".repeat(cnt - 1));
            }
        }

        System.out.print(sb);

        br.close();
    }
}
