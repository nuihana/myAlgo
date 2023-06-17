package BaekJoon.Solve2023.June.StonglyConnectedComponent;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Problem16367 {
    int nodeCnt;
    List<Integer>[] graph;
    List<List<Integer>> scc;
    Stack<Integer> stack;
    int[] dfsn;
    boolean[] finished;
    int[] group;
    int dfsnum;
    int groupnum;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        nodeCnt = Integer.parseInt(st.nextToken());
        int guesserCnt = Integer.parseInt(st.nextToken());

        graph = new ArrayList[nodeCnt * 2 + 1];
        scc = new ArrayList<>();
        scc.add(new ArrayList<>());
        for (int i = 1; i <= nodeCnt * 2; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < guesserCnt; i++) {
            st = new StringTokenizer(br.readLine());

            int idx1 = Integer.parseInt(st.nextToken());
            String val1 = st.nextToken();
            int idx2 = Integer.parseInt(st.nextToken());
            String val2 = st.nextToken();
            int idx3 = Integer.parseInt(st.nextToken());
            String val3 = st.nextToken();

            graph[idx(idx1, oppo(val1))].add(idx(idx2, val2));
            graph[idx(idx1, oppo(val1))].add(idx(idx3, val3));
            graph[idx(idx2, oppo(val2))].add(idx(idx1, val1));
            graph[idx(idx2, oppo(val2))].add(idx(idx3, val3));
            graph[idx(idx3, oppo(val3))].add(idx(idx1, val1));
            graph[idx(idx3, oppo(val3))].add(idx(idx2, val2));
        }

        stack = new Stack<>();
        dfsn = new int[nodeCnt * 2 + 1];
        finished = new boolean[nodeCnt * 2 + 1];
        group = new int[nodeCnt * 2 + 1];
        dfsnum = 0;
        groupnum = 0;

        for (int i = 1; i <= nodeCnt * 2; i++) {
            if (dfsn[i] == 0) dfs(i);
        }

        boolean flag = true;
        for (int i = 1; i <= nodeCnt; i++) {
            if (group[i] == group[i + nodeCnt]) {
                flag = false;
                break;
            }
        }

        if (flag) {
            bw.write(getAnswer());
        } else {
            bw.write("-1");
        }

        br.close();
        bw.close();
    }

    private String oppo(String val) {
        if (val.equals("B")) {
            return "R";
        } else {
            return "B";
        }
    }

    private int idx(int in, String val) {
        if (val.equals("B")) { // Red : in, Blue : in + N
            in = -in;
        }

        return (0 < in && in < nodeCnt + 1) ? in : -in + nodeCnt;
    }

    private int dfs(int idx) {
        dfsn[idx] = ++dfsnum;
        stack.push(idx);

        int parent = dfsn[idx];
        for (int next : graph[idx]) {
            if (dfsn[next] == 0) {
                parent = Math.min(parent, dfs(next));
            } else if (!finished[next]) {
                parent = Math.min(parent, dfsn[next]);
            }
        }

        if (parent == dfsn[idx]) {
            groupnum++;
            scc.add(new ArrayList<>());

            while (true) {
                int item = stack.pop();
                finished[item] = true;
                group[item] = groupnum;
                scc.get(groupnum).add(item);
                if (item == idx) break;
            }
        }

        return parent;
    }

    private String getAnswer() {
        String[] res = new String[nodeCnt + 1];

        for (int i = groupnum; i > 0; i--) {
            for (int node : scc.get(i)) {
                String val = node > nodeCnt ? "R" : "B";
                int idx = node > nodeCnt ? node - nodeCnt / 2 : node;
                if (res[idx] == null) {
                    res[idx] = val;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= nodeCnt; i++) {
            sb.append(res[i]);
        }

        return sb.toString();
    }
}
