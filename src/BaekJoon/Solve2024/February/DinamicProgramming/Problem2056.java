package BaekJoon.Solve2024.February.DinamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Problem2056 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int cnt = Integer.parseInt(br.readLine());
        int[] time = new int[cnt + 1];
        Set<Integer>[] condition = new HashSet[cnt + 1];
        for (int i = 1; i <= cnt; i++) {
            condition[i] = new HashSet<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            int spend = Integer.parseInt(st.nextToken());
            time[i] = spend;

            int preCnt = Integer.parseInt(st.nextToken());
            for (int j = 0; j < preCnt; j++) {
                int preIdx = Integer.parseInt(st.nextToken());
                condition[i].add(preIdx);
            }
        }

        int[] dp = new int[cnt + 1];
        dp[1] = time[1];
        int max = dp[1];
        for (int i = 2; i <= cnt; i++) {
            int now = 0;
            for (int pre : condition[i]) {
                now = Math.max(now, dp[pre]);
            }
            dp[i] = now + time[i];
            max = Math.max(max, dp[i]);
        }
        System.out.print(max);

        br.close();
    }
}
