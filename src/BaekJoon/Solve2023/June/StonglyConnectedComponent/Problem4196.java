package BaekJoon.Solve2023.June.StonglyConnectedComponent;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Problem4196 {
    List<List<Integer>> graph;
    int[] dfsn;
    int[] group;
    boolean[] finished;
    Stack<Integer> stack;
    int ord;
    int groupCnt;
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int caseCnt = Integer.parseInt(br.readLine());
        for (int i = 0; i < caseCnt; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int nodeCnt = Integer.parseInt(st.nextToken());
            int lineCnt = Integer.parseInt(st.nextToken());

            graph = new ArrayList<>();
            for (int j = 0; j <= nodeCnt; j++) {
                graph.add(new ArrayList<>());
            }

            for (int j = 0; j < lineCnt; j++) {
                st = new StringTokenizer(br.readLine());

                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                graph.get(a).add(b);
            }

            dfsn = new int[nodeCnt + 1];
            group = new int[nodeCnt + 1];
            finished = new boolean[nodeCnt + 1];
            stack = new Stack<>();
            ord = 0;
            groupCnt = 0;

            for (int j = 1; j <= nodeCnt; j++) {
                if (dfsn[j] == 0) {
                    dfs(j);
                }
            }

            boolean[] isRoot = new boolean[groupCnt + 1];
            for (int j = 1; j <= nodeCnt; j++) {
                for (int next : graph.get(j)) {
                    if (group[next] != group[j])
                        isRoot[group[next]] = true;
                }
            }

            int cnt = 0;
            for (int j = 1; j <= groupCnt; j++) {
                if (!isRoot[j])
                    cnt++;
            }

            bw.write(String.valueOf(cnt));
            bw.newLine();
        }

        br.close();
        bw.close();
    }

    private int dfs(int idx) {
        dfsn[idx] = ++ord;
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
            groupCnt++;

            while(true) {
                int item = stack.pop();
                finished[item] = true;
                group[item] = groupCnt;
                if (item == idx) {
                    break;
                }
            }
        }

        return parent;
    }
}
