package BaekJoon.Solve2025.December.BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem14650 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        System.out.print(getRes(n, 0));

        br.close();
    }

    private int getRes(int n, int val) {
        if (n == 0) {
            if (val % 3 == 0) return 1;
            else return 0;
        }

        int res = 0;
        if (val != 0) res += getRes(n - 1, val * 10);
        res += getRes(n - 1, val * 10 + 1);
        res += getRes(n - 1, val * 10 + 2);

        return res;
    }
}
