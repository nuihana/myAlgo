package BaekJoon.Solve2025.May.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem3004 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int res = 2;
        for (int i = 2; i <= n; i++) {
            res += (i / 2) + 1;
        }
        System.out.print(res);

        br.close();
    }
}
