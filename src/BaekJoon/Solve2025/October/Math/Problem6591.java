package BaekJoon.Solve2025.October.Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem6591 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            if (n == 0 && k == 0) break;

            long res = 1;
            if (k > n - k) k = n - k;
            for (long i = 1; i <= k; i++) {
                res *= n--;
                res /= i;
            }

            sb.append(res).append("\n");
        }
        System.out.print(sb);

        br.close();
    }
}
