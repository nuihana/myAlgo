package BaekJoon.Solve2025.June.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem8320 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int res = n;
        for (int div = 2; n / div > 0; div++) {
            int wid = div;
            while (wid++ * div <= n) res++;
        }
        System.out.print(res);

        br.close();
    }
}
