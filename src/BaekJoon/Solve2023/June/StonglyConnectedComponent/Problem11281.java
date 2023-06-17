package BaekJoon.Solve2023.June.StonglyConnectedComponent;

import java.io.*;
import java.util.*;

public class Problem11281 {
    int nodeCnt;
    List<List<Integer>> graph;
    List<List<Integer>> scc;
    Stack<Integer> stack;
    int[] dfsn;
    int[] group;
    boolean[] finished;
    int dfsnum;
    int groupnum;
    int[] seq;
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        nodeCnt = Integer.parseInt(st.nextToken());
        int lineCnt = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        scc = new ArrayList<>();
        scc.add(new ArrayList<>());
        for(int i = 0; i <= nodeCnt * 2; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < lineCnt; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph.get(index(-a)).add(index(b));
            graph.get(index(-b)).add(index(a));
        }

        stack = new Stack<>();
        dfsn = new int[nodeCnt * 2 + 1];
        group = new int[nodeCnt * 2 + 1];
        finished = new boolean[nodeCnt * 2 + 1];
        dfsnum = 0;
        groupnum = 0;

        for (int i = 1; i <= nodeCnt * 2; i++) {
            if (dfsn[i] == 0)
                dfs(i);
        }

        String isPossible = "1";
        for (int i = 1; i <= nodeCnt; i++) {
            if (group[i] == group[i + nodeCnt]) {
                isPossible = "0";
                break;
            }
        }

        bw.write(isPossible);
        if (isPossible.equals("1")) {
            bw.newLine();

            seq = new int[nodeCnt + 1];
            Arrays.fill(seq, -1);
            bw.write(backtracking());
        }

        br.close();
        bw.close();
    }

    private int index(int idx) {
        return (0 < idx && idx < nodeCnt + 1) ? idx : -idx + nodeCnt;
    }

    private int dfs(int idx) {
        dfsn[idx] = ++dfsnum;
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
            groupnum++;
            scc.add(new ArrayList<>());

            while(true) {
                int item = stack.pop();
                finished[item] = true;
                group[item] = groupnum;
                scc.get(groupnum).add(item);
                if (item == idx) break;
            }
        }

        return parent;
    }

    private String backtracking() {
        for (int i = groupnum; i > 0; i--) {
            for (int next : scc.get(i)) {
                int now = Math.abs(index(next));
                if (seq[now] == -1) {
                    if (next > nodeCnt) {
                        seq[now] = 1;
                    } else {
                        seq[now] = 0;
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < seq.length; i++) {
            sb.append(seq[i]).append(" ");
        }

        return sb.toString();
    }
}
