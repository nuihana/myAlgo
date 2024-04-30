package BaekJoon.Solve2024.April.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Problem11060 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        PriorityQueue<int[]> pq = new PriorityQueue<>((a1, a2) -> a1[1] - a2[1]);
        int end = Integer.parseInt(br.readLine());
        int[] maze = new int[end];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < end; i++) {
            maze[i] = Integer.parseInt(st.nextToken());
        }

        int res = -1;
        int[] dp = new int[end];
        Arrays.fill(dp, 1000);
        pq.offer(new int[]{ 0, 0 });
        dp[0] = 0;
        while (!pq.isEmpty()) {
            int[] now = pq.poll();

            if (now[0] == end - 1) {
                res = now[1];
                break;
            }

            for (int i = 1; i <= maze[now[0]]; i++) {
                int next = now[0] + i;
                if (next < end && dp[next] > now[1] + 1) {
                    dp[next] = now[1] + 1;
                    pq.offer(new int[]{ now[0] + i, now[1] + 1 });
                }
            }
        }

        System.out.print(res);

        br.close();
    }
}
