package BaekJoon.Solve2025.December.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem12845 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int max = -1;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            int level = Integer.parseInt(st.nextToken());
            max = Math.max(max, level);
            sum += level;
        }

        if (n == 1) {
            System.out.print(sum);
        } else {
            System.out.print(max * (n - 2) + sum);
        }

        br.close();
    }
}
