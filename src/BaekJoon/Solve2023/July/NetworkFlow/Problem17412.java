package BaekJoon.Solve2023.July.NetworkFlow;

import java.io.*;
import java.util.*;

public class Problem17412 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int vCnt = Integer.parseInt(st.nextToken());
        int eCnt = Integer.parseInt(st.nextToken());

        int[][] capacity = new int[vCnt + 1][vCnt + 1], flow = new int[vCnt + 1][vCnt + 1];
        List<Integer>[] eList = new ArrayList[vCnt + 1];
        for (int i = 1; i <= vCnt; i++) {
            eList[i] = new ArrayList<>();
        }

        for (int i = 0; i < eCnt; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            capacity[from][to] = 1;

            eList[from].add(to);
            eList[to].add(from);
        }

        final int SOURCE = 1;
        final int SINK = 2;
        int totalFlow = 0;
        while(true) {
            int[] parent = new int[vCnt + 1];
            Arrays.fill(parent, -1);
            Queue<Integer> que = new LinkedList<>();
            parent[SOURCE] = SOURCE;
            que.offer(SOURCE);

            while(!que.isEmpty() && parent[SINK] == -1) {
                int now = que.poll();
                for (int next : eList[now]) {
                    if(capacity[now][next] - flow[now][next] > 0 && parent[next] == -1) {
                        que.offer(next);
                        parent[next] = now;
                    }
                }
            }

            if (parent[SINK] == -1) break;

            int minFlow = Integer.MAX_VALUE;
            for (int i = SINK; i != SOURCE; i = parent[i]) {
                minFlow = Math.min(minFlow, capacity[parent[i]][i] - flow[parent[i]][i]);
            }
            for (int i = SINK; i != SOURCE; i = parent[i]) {
                flow[parent[i]][i] += minFlow;
                flow[i][parent[i]] -= minFlow;
            }

            totalFlow += minFlow;
        }

        bw.write(String.valueOf(totalFlow));

        br.close();
        bw.close();
    }
}
