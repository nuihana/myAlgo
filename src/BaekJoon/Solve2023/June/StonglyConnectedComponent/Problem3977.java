package BaekJoon.Solve2023.June.StonglyConnectedComponent;

import java.io.*;
import java.util.*;

public class Problem3977 {
    List<List<Integer>> graph;
    Stack<Integer> stack;
    int[] dfsn;
    boolean[] isDone;
    int[] group;
    int dfsIdx;
    int groupIdx;
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int caseCnt = Integer.parseInt(br.readLine());
        for (int caseIdx = 0; caseIdx < caseCnt; caseIdx++) {
            if (caseIdx != 0) {
                br.readLine();
            }

            StringTokenizer st = new StringTokenizer(br.readLine());

            int nodeCnt = Integer.parseInt(st.nextToken());
            int lineCnt = Integer.parseInt(st.nextToken());

            graph = new ArrayList<>();
            for (int i = 0; i < nodeCnt; i++) {
                graph.add(new ArrayList<>());
            }

            for (int i = 0; i < lineCnt; i++) {
                st = new StringTokenizer(br.readLine());

                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                graph.get(a).add(b);
            }

            dfsn = new int[nodeCnt];
            isDone = new boolean[nodeCnt];
            group = new int[nodeCnt];
            stack = new Stack<>();
            dfsIdx = 0;
            groupIdx = 0;

            for (int i = 0; i < nodeCnt; i++) {
                if (dfsn[i] == 0) {
                    dfs(i);
                }
            }

            int[] indegree = new int[groupIdx];

            for (int i = 0; i < nodeCnt; i++) {
                for (int node : graph.get(i)) {
                    if (group[node] != group[i])
                        indegree[group[node]]++;
                }
            }

            int cnt = 0;
            int idx = 0;
            for (int i = 0; i < groupIdx; i++) {
                if (indegree[i] == 0) {
                    idx = i;
                    cnt++;
                }
            }

            if (cnt > 1) {
                bw.write("Confused");
                bw.newLine();
            } else {
                for (int i = 0; i < nodeCnt; i++) {
                    if (group[i] == idx) {
                        bw.write(String.valueOf(i));
                        bw.newLine();
                    }
                }
            }
            bw.newLine();
        }

        br.close();
        bw.close();
    }

    private int dfs(int idx) {
        dfsn[idx] = ++dfsIdx;
        stack.add(idx);

        int parent = dfsn[idx];
        for (int next : graph.get(idx)) {
            if (dfsn[next] == 0) {
                parent = Math.min(parent, dfs(next));
            } else if (!isDone[next]) {
                parent = Math.min(parent, dfsn[next]);
            }
        }

        if (parent == dfsn[idx]) {
            while(true) {
                int item = stack.pop();
                isDone[item] = true;
                group[item] = groupIdx;
                if (item == idx) break;
            }

            groupIdx++;
        }

        return parent;
    }
}
