package BaekJoon.Solve2024.July.BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem10211 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());

            int[] partSum = new int[n];
            partSum[0] = Integer.parseInt(st.nextToken());
            int res = partSum[0];
            for (int i = 1; i < n; i++) {
                partSum[i] = partSum[i - 1] + Integer.parseInt(st.nextToken());
                res = Math.max(res, partSum[i]);
            }

            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    res = Math.max(res, partSum[j] - partSum[i]);
                }
            }

            sb.append(res).append("\n");
        }

        System.out.print(sb);

        br.close();
    }
}
