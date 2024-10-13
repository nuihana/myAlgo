package BaekJoon.Solve2024.October.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem1075 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int f = Integer.parseInt(br.readLine());

        System.out.print(printLastTwo(n, f));

        br.close();
    }

    private String printLastTwo(int val, int div) {
        val = val / 100 * 100;
        int res = -1;
        for (int i = 0; i < 100; i++) {
            if ((val + i) % div == 0) {
                res = i;
                break;
            }
        }
        return res >= 10 ? String.valueOf(res) : "0".concat(String.valueOf(res));
    }
}
