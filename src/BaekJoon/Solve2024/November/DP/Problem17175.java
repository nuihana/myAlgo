package BaekJoon.Solve2024.November.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem17175 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] mem = new int[n + 1];
        System.out.print(memoization(mem, n));

        br.close();
    }

    private int memoization(int[] mem, int idx) {
        if (idx < 2) return mem[idx] = 1;
        if (mem[idx] > 0) return mem[idx];
        return mem[idx] = (memoization(mem, idx - 2) + memoization(mem, idx - 1) + 1) % 1000000007;
    }
}
