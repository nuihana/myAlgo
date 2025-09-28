package BaekJoon.Solve2025.September.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem11586 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String[] src = new String[n];
        for (int i = 0; i < n; i++) {
            src[i] = br.readLine();
        }

        int k = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        if (k == 1) {
            for (String s : src) {
                sb.append(s).append("\n");
            }
        } else if (k == 2) {
            for (String s : src) {
                StringBuilder isb = new StringBuilder();
                isb.append(s);
                sb.append(isb.reverse().toString()).append("\n");
            }
        } else if (k == 3) {
            for (int i = src.length - 1; i >= 0; i--) {
                sb.append(src[i]).append("\n");
            }
        }
        System.out.print(sb);

        br.close();
    }
}
