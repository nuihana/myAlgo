package BaekJoon.Solve2026.January.TopologySort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Problem14567 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] condition = new int[n + 1];
        List<Integer>[] list = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list[a].add(b);
            condition[b]++;
        }

        int[] res = new int[n + 1];
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            if (condition[i] == 0) q.offer(i);
        }

        int idx = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            idx++;

            for (int i = 0; i < size; i++) {
                int now = q.poll();
                res[now] = idx;

                for (int j : list[now]) {
                    condition[j]--;

                    if (condition[j] == 0) q.offer(j);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append(res[i]).append(" ");
        }
        System.out.print(sb);

        br.close();
    }
}
