package BaekJoon.Solve2025.Feburary.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Problem6359 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());

            boolean[] isOpen = new boolean[n + 1];
            Arrays.fill(isOpen, true);
            for (int i = 2; i <= n; i++) {
                for (int j = 1; i * j <= n; j++) {
                    isOpen[i * j] = !isOpen[i * j];
                }
            }

            int res = 0;
            for (int i = 1; i <= n; i++) {
                if (isOpen[i]) res++;
            }
            sb.append(res).append("\n");
        }
        System.out.print(sb);

        br.close();
    }
}
