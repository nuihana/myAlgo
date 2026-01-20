package BaekJoon.Solve2026.January.DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem9711 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        long[] cache = new long[10001];
        StringBuilder sb = new StringBuilder();
        int idx = 1;
        while (t-- > 0) {
            Arrays.fill(cache, -1);
            StringTokenizer st = new StringTokenizer(br.readLine());

            int p = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());

            sb.append("Case #").append(idx++).append(": ").append(fbnc(p, cache, q)).append("\n");
        }
        System.out.print(sb);

        br.close();
    }

    private long fbnc(int n, long[] cache, int q) {
        if (n == 1 || n == 2) return 1 % q;
        if (cache[n] != -1) return cache[n];
        return cache[n] = (fbnc(n - 1, cache, q) + fbnc(n - 2, cache, q)) % q;
    }
}
