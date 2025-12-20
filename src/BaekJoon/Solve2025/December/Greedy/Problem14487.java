package BaekJoon.Solve2025.December.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem14487 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int sum = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        int max = -1;
        for (int i = 0; i < n; i++) {
            int cost = Integer.parseInt(st.nextToken());
            max = Math.max(max, cost);
            sum += cost;
        }
        System.out.print(sum - max);

        br.close();
    }
}
