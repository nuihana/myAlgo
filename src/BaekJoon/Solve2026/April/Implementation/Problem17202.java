package BaekJoon.Solve2026.April.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem17202 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String a = br.readLine();
        String b = br.readLine();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            sb.append(a.charAt(i)).append(b.charAt(i));
        }

        String src = sb.toString();
        while (src.length() > 2) {
            sb = new StringBuilder();

            for (int i = 0; i < src.length() - 1; i++) {
                int ta = src.charAt(i) - '0';
                int tb = src.charAt(i + 1) - '0';
                int sum = ta + tb;
                sb.append(sum % 10);
            }

            src = sb.toString();
        }

        System.out.print(src);

        br.close();
    }
}
