package BaekJoon.Solve2025.May.Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem11966 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long n = Long.parseLong(br.readLine());

        long chk = 1;
        boolean res = false;
        while (chk <= n) {
            if (chk == n) {
                res = true;
                break;
            }

            chk *= 2;
        }

        if (res) {
            System.out.print(1);
        } else {
            System.out.print(0);
        }

        br.close();
    }
}
