package BaekJoon.Solve2024.August.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem5555 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String src = br.readLine();
        int n = Integer.parseInt(br.readLine());
        int res = 0;
        while (n-- > 0) {
            String cpr = br.readLine();
            boolean isContain = false;
            for (int i = 0; i < cpr.length() && !isContain; i++) {
                for (int j = 0; j < src.length(); j++) {
                    if (src.charAt(j) != cpr.charAt((i + j) % cpr.length())) break;
                    if (j == src.length() - 1) isContain = true;
                }
            }

            if (isContain) res++;
        }

        System.out.print(res);

        br.close();
    }
}
