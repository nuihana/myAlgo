package BaekJoon.Solve2024.November.Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem2622 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int res = 0;
        for (int i = 1; i < n; i++) {
            for (int j = i; j < n; j++) {
                int k = n - (i + j);
                if (k < j) break;
                if (i + j > k) res++;
            }
        }

        System.out.print(res);

        br.close();
    }
}
