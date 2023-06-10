package BaekJoon.Solve2023.June.StonglyConnectedComponent;

import java.io.*;
import java.util.*;

public class Problem2150 {
    List<List<Integer>> graph;
    List<List<Integer>> result;
    Stack<Integer> stack;
    int[] dfsn;
    boolean[] finished;
    int ord = 0;
    int grpNum = 0;
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int nodeCnt = Integer.parseInt(st.nextToken());
        int lineCnt = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        result = new ArrayList<>();
        for (int i = 0; i <= nodeCnt; i++) {
            graph.add(new ArrayList<>());
            result.add(new ArrayList<>());
        }

        for (int i = 0; i < lineCnt; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph.get(a).add(b);
        }

        dfsn = new int[nodeCnt + 1];
        finished = new boolean[nodeCnt + 1];

        stack = new Stack<>();
        for (int i = 1; i <= nodeCnt; i++) {
            if (dfsn[i] == 0) {
                dfs(i);
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(grpNum).append("\n");

        TreeMap<Integer, Integer> tm = new TreeMap<>();
        for (int i = 0; i < grpNum; i++) {
            Collections.sort(result.get(i));

            tm.put(result.get(i).get(0), i);
        }

        tm.keySet().forEach(key -> {
            int ord = tm.get(key);

            for (int item : result.get(ord)) {
                sb.append(item).append(" ");
            }
            sb.append("-1\n");
        });

        bw.write(sb.toString());

        br.close();
        bw.close();
    }

    private int dfs(int start) {
        dfsn[start] = ++ord;
        stack.add(start);

        int parent = dfsn[start];
        for (int next : graph.get(start)) {
            if (dfsn[next] == 0) {
                parent = Math.min(parent, dfs(next));
            } else if (!finished[next]) {
                parent = Math.min(parent, dfsn[next]);
            }
        }

        if (parent == dfsn[start]) {
            while (true) {
                int t = stack.pop();
                finished[t] = true;
                result.get(grpNum).add(t);

                if (t == start) break;
            }

            grpNum++;
        }

        return parent;
    }
}
