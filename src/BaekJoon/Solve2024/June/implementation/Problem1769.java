package BaekJoon.Solve2024.June.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem1769 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String x = br.readLine();

        int turn = 0;
        int calc = -1;
        if (x.length() == 1) {
            calc = Integer.parseInt(x);
        } else {
            turn = 1;
            calc = 0;
            for (int i = 0; i < x.length(); i++) {
                calc += (x.charAt(i) - '0');
            }

            while (true) {
                if (calc < 10) break;

                int tmp = 0;

                while (calc > 0) {
                    tmp += calc % 10;
                    calc /= 10;
                }

                calc = tmp;
                turn++;
            }
        }

        System.out.println(turn);
        System.out.print(calc % 3 == 0 ? "YES" : "NO");

        br.close();
    }
}
