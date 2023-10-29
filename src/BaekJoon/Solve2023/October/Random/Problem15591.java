package BaekJoon.Solve2023.October.Random;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Problem15591 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int quest = Integer.parseInt(st.nextToken());
        List<int[]>[] usd = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) usd[i] = new ArrayList<>();
        for (int i = 1; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());

            usd[p].add(new int[]{q, r});
            usd[q].add(new int[]{p, r});
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < quest; i++) {
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            boolean[] visit = new boolean[n + 1];
            visit[v] = true;
            Queue<Integer> que = new LinkedList<>();
            que.add(v);

            int ans = 0;
            while (!que.isEmpty()) {
                int now = que.poll();

                for (int[] p : usd[now]) {
                    if (!visit[p[0]] && p[1] >= k) {
                        que.add(p[0]);
                        visit[p[0]] = true;
                        ans++;
                    }
                }
            }
            sb.append(ans).append("\n");
        }

        System.out.print(sb);

        br.close();
    }
}
