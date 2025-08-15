package BaekJoon.Solve2025.August.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem5613 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int res = Integer.parseInt(br.readLine());
        while (true) {
            String src = br.readLine();
            if (src.equals("=")) break;

            int next = Integer.parseInt(br.readLine());
            if (src.equals("+")) {
                res += next;
            } else if (src.equals("-")) {
                res -= next;
            } else if (src.equals("*")) {
                res *= next;
            } else if (src.equals("/")) {
                res /= next;
            }
        }
        System.out.print(res);

        br.close();
    }
}
