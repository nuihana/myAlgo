package BaekJoon.Solve2025.April.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem2921 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        long res = 0;
        for (int i = 1; i <= n; i++) {
            res += i * (n + 2);
        }

        System.out.print(res);

        br.close();
    }
}
