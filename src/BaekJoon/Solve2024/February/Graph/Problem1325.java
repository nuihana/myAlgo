package BaekJoon.Solve2024.February.Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Problem1325 {
    ArrayList<Integer>[] graph;
    int[] isVisited, leafCnt;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int nodeCnt = Integer.parseInt(st.nextToken());
        int edgeCnt = Integer.parseInt(st.nextToken());

        leafCnt = new int[nodeCnt + 1];
        graph = new ArrayList[nodeCnt + 1];
        for (int i = 1; i <= nodeCnt; i++) graph[i] = new ArrayList<>();
        for (int i = 0; i < edgeCnt; i++) {
            st = new StringTokenizer(br.readLine());
            int child = Integer.parseInt(st.nextToken());
            int parent = Integer.parseInt(st.nextToken());
            graph[child].add(parent);
        }

        for(int i = 1; i <= nodeCnt; i++) {
            isVisited = new int[nodeCnt + 1];
            bfs(i);
        }

        int max = 0;
        for (int i = 1; i <= nodeCnt; i++) {
            max = Math.max(max, leafCnt[i]);
        }

        for (int i = 1; i <= nodeCnt; i++) {
            if (leafCnt[i] == max) {
                System.out.print(i + " ");
            }
        }

        br.close();
    }

    private void bfs(int idx) {
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(idx);
        isVisited[idx] = 1;
        while (!q.isEmpty()) {
            int now = q.poll();
            for (int next : graph[now]) {
                if (isVisited[next] == 0) {
                    leafCnt[next]++;
                    isVisited[next] = 1;
                    q.offer(next);
                }
            }
        }
    }
}
