package BaekJoon.Solve2025.September.BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem9094 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while (tc-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            int res = 0;
            for (int b = 1; b < n; b++) {
                for (int a = 1; a < b; a++) {
                    if ((a * a + b * b + m) % (a * b) == 0) res++;
                }
            }
            sb.append(res).append("\n");
        }
        System.out.print(sb);

        br.close();
    }
}
