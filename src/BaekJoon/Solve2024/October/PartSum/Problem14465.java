package BaekJoon.Solve2024.October.PartSum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem14465 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int[] broken = new int[n + 1];
        for (int i = 0; i < b; i++) {
            int idx = Integer.parseInt(br.readLine());
            broken[idx]++;
        }

        int sum = 0;
        for (int i = 1; i <= k; i++) {
            sum += broken[i];
        }
        int min = sum;

        for (int i = k + 1; i <= n; i++) {
            sum += broken[i];
            sum -= broken[i - k];
            min = Math.min(min, sum);
        }

        System.out.print(min);

        br.close();
    }
}
