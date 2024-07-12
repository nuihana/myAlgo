package BaekJoon.Solve2024.July.Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Problem5972 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int nodeCnt = Integer.parseInt(st.nextToken());
        int edgeCnt = Integer.parseInt(st.nextToken());

        List<int[]>[] costList = new List[nodeCnt + 1];
        for (int i = 1; i <= nodeCnt; i++) costList[i] = new ArrayList<>();

        for (int i = 0; i < edgeCnt; i++) {
            st = new StringTokenizer(br.readLine());

            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int amount = Integer.parseInt(st.nextToken());

            costList[from].add(new int[]{ to, amount });
            costList[to].add(new int[]{ from, amount });
        }

        int[] res = new int[nodeCnt + 1];
        Arrays.fill(res, Integer.MAX_VALUE);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a1, a2) -> a1[1] - a2[1]);
        boolean[] isVisited = new boolean[nodeCnt + 1];
        res[1] = 0;
        isVisited[1] = true;
        for (int[] next : costList[1]) pq.offer(next);
        while (!pq.isEmpty()) {
            int[] now = pq.poll();

            if (isVisited[now[0]]) continue;
            isVisited[now[0]] = true;
            res[now[0]] = now[1];

            for (int[] next : costList[now[0]]) {
                pq.offer(new int[]{ next[0], now[1] + next[1] });
            }
        }

        System.out.print(res[nodeCnt]);

        br.close();
    }
}
