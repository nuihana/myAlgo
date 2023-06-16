package BaekJoon.Solve2023.June.StonglyConnectedComponent;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Problem3648 {
    List<Integer>[] graph;
    Stack<Integer> stack;
    int[] dfsn;
    int[] group;
    boolean[] finished;
    int dfsnum;
    int groupnum;
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while(true) {
            String input = br.readLine();
            if (input == null || input.equals("")) {
                break;
            }

            StringTokenizer st = new StringTokenizer(input, " ");
            int nodeCnt = Integer.parseInt(st.nextToken());
            int lineCnt = Integer.parseInt(st.nextToken());

            graph = new ArrayList[nodeCnt * 2 + 1];
            for (int i = 0; i <= nodeCnt * 2; i++) {
                graph[i] = new ArrayList<>();
            }
            graph[convertIdx(-1)].add(convertIdx(1));

            for (int i = 0; i < lineCnt; i++) {
                st = new StringTokenizer(br.readLine());

                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                graph[convertIdx(-a)].add(convertIdx(b));
                graph[convertIdx(-b)].add(convertIdx(a));
            }

            stack = new Stack<>();
            dfsn = new int[nodeCnt * 2 + 1];
            group = new int[nodeCnt * 2 + 1];
            finished = new boolean[nodeCnt * 2 + 1];
            dfsnum = 0;
            groupnum = 0;

            for (int i = 1; i <= nodeCnt * 2; i++) {
                if (dfsn[i] == 0) dfs(i);
            }

            String res = "yes";
            for (int i = 1; i <= nodeCnt; i++) {
                if (group[convertIdx(i)] == group[convertIdx(-i)])
                    res = "no";
            }

            bw.write(res);
            bw.newLine();
        }

        br.close();
        bw.close();
    }

    private int convertIdx(int num) {
        return num < 0 ? -num * 2 - 1 : num * 2;
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

            while(true) {
                int item = stack.pop();
                group[item] = groupnum;
                finished[item] = true;
                if (item == idx) break;
            }
        }

        return parent;
    }
}
