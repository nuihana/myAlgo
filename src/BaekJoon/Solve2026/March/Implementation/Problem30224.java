package BaekJoon.Solve2026.March.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem30224 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        boolean include = false;
        int tmp = n;
        while (tmp > 0) {
            if (tmp % 10 == 7) include = true;
            tmp /= 10;
        }

        if (include) {
            if (n % 7 == 0) System.out.print(3);
            else System.out.print(2);
        } else {
            if (n % 7 == 0) System.out.print(1);
            else System.out.print(0);
        }

        br.close();
    }
}
