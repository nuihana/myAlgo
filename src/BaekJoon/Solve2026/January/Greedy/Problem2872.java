package BaekJoon.Solve2026.January.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem2872 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] book = new int[n];
        for (int i = 0; i < n; i++) {
            book[i] = Integer.parseInt(br.readLine());
        }

        int res = 0, idx = n;
        for (int i = n - 1; i >= 0; i--) {
            if (book[i] == idx) idx--;
            else res++;
        }
        System.out.print(res);

        br.close();
    }
}
