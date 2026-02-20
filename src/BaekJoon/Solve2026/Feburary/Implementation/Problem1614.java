package BaekJoon.Solve2026.Feburary.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem1614 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        long cnt = Long.parseLong(br.readLine());

        long res = 0;
        if (1 <= cnt) {
            res += 5;
            if (n != 1 && n != 5) res += ((cnt - 1) * 4);
            else res += ((cnt - 1) * 4 * 2);

            if (n == 1) res += 3;
            else if (n == 5) res += 7;
            else if (cnt % 2 == 0) res += n - 2;
            else res += 4 - n;
        } else {
            res += n - 1;
        }

        System.out.print(res);

        br.close();
    }
}
