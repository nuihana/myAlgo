package BaekJoon.Solve2023.June.StonglyConnectedComponent;

import java.io.*;
import java.util.*;

public class Problem4013 {
    List<List<Integer>> graph;
    Stack<Integer> stack;
    int[] dfsn;
    int[] group;
    boolean[] finished;
    int dfsIdx;
    int groupIdx;
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int nodeCnt = Integer.parseInt(st.nextToken());
        int lineCnt = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        for (int i = 0; i <= nodeCnt; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < lineCnt; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph.get(a).add(b);
        }

        stack = new Stack<>();
        dfsn = new int[nodeCnt + 1];
        group = new int[nodeCnt + 1];
        finished = new boolean[nodeCnt + 1];
        dfsIdx = 0;
        groupIdx = 0;

        for (int i = 1; i <= nodeCnt; i++) {
            if (dfsn[i] == 0)
                dfs(i);
        }

        int[] dp = new int[groupIdx + 1];
        int[] moneyArr = new int[groupIdx + 1];
        List<List<Integer>> scc = new ArrayList<>();
        for (int i = 0; i <= groupIdx; i++) {
            scc.add(new ArrayList<>());
        }

        for (int i = 1; i <= nodeCnt; i++) {
            int amount = Integer.parseInt(br.readLine());
            moneyArr[group[i]] += amount;
            for (int next : graph.get(i)) {
                if (group[next] != group[i])
                    scc.get(group[i]).add(group[next]);
            }
        }

        st = new StringTokenizer(br.readLine());
        int start = group[Integer.parseInt(st.nextToken())];
        int resCnt = Integer.parseInt(st.nextToken());

        int[] resIdx = new int[resCnt];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < resCnt; i++) {
            resIdx[i] = Integer.parseInt(st.nextToken());
        }

        Queue<Integer> que = new LinkedList<>();
        dp[start] = moneyArr[start];
        que.offer(start);

        while (!que.isEmpty()) {
            int now = que.poll();
            for (int next : scc.get(now)) {
                if (dp[next] < dp[now] + moneyArr[next]) {
                    dp[next] = dp[now] + moneyArr[next];
                    que.offer(next);
                }
            }
        }

        int answer = 0;
        for (int i = 0; i < resCnt; i++) {
            answer = Math.max(answer, dp[group[resIdx[i]]]);
        }
        bw.write(String.valueOf(answer));

        br.close();
        bw.close();
    }

    private int dfs(int idx) {
        dfsn[idx] = ++dfsIdx;
        stack.push(idx);

        int parent = dfsn[idx];
        for (int next : graph.get(idx)) {
            if (dfsn[next] == 0) {
                parent = Math.min(parent, dfs(next));
            } else if (!finished[next]) {
                parent = Math.min(parent, dfsn[next]);
            }
        }

        if (parent == dfsn[idx]) {
            groupIdx++;

            while(true) {
                int item = stack.pop();
                finished[item] = true;
                group[item] = groupIdx;
                if (item == idx) break;
            }
        }

        return parent;
    }
}
