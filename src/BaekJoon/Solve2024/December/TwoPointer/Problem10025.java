package BaekJoon.Solve2024.December.TwoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem10025 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] amount = new int[1000001];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int g = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());

            amount[x] += g;
        }

        int l = 0;
        int r = k * 2;
        long tot = 0;
        for (int i = l; i <= r && i <= 1000000; i++) {
            tot += amount[i];
        }

        long res = tot;
        for (int i = r + 1; i <= 1000000; i++) {
            tot -= amount[i - r - 1];
            tot += amount[i];
            res = Math.max(res, tot);
        }

        System.out.print(res);

        br.close();
    }
}
