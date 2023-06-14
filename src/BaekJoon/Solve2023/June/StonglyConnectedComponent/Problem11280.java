package BaekJoon.Solve2023.June.StonglyConnectedComponent;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Problem11280 {
    List<List<Integer>> graph;
    Stack<Integer> stack;
    int[] dfsn;
    int[] group;
    boolean[] finished;
    int dfsnum;
    int groupnum;
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int nodeCnt = Integer.parseInt(st.nextToken());
        int lineCnt = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>(); // n : 2 * n | -n : 2 * n - 1
        int conMaxNode = nodeCnt * 2;
        for (int i = 0; i <= conMaxNode; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < lineCnt; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            a = a < 0 ? a * -1 * 2 - 1 : a * 2;
            b = b < 0 ? b * -1 * 2 - 1 : b * 2;

            graph.get(not(a)).add(b);
            graph.get(not(b)).add(a);
        }

        stack = new Stack<>();
        dfsn = new int[conMaxNode + 1];
        group = new int[conMaxNode + 1];
        finished = new boolean[conMaxNode + 1];
        dfsnum = 0;
        groupnum = 0;

        for (int i = 1; i <= conMaxNode; i++) {
            if (dfsn[i] == 0) {
                dfs(i);
            }
        }

        int result = 1;
        for (int i = 1; i <= nodeCnt; i++) {
            if (group[i * 2] == group[i * 2 - 1]) {
                result = 0;
                break;
            }
        }

        bw.write(String.valueOf(result));

        br.close();
        bw.close();
    }

    private int not(int idx) {
        return idx % 2 == 0 ? idx - 1 : idx + 1;
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

            while(true) {
                int item = stack.pop();
                finished[item] = true;
                group[item] = groupnum;
                if (item == idx) break;
            }
        }

        return parent;
    }
}
