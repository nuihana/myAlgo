package BaekJoon.Solve2023.April.Tree;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Problem1967 {
    Node[] nodeArr;
    boolean[] visited;
    int endNode;
    int result = 0;
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int nodeCnt = Integer.parseInt(br.readLine());
        nodeArr = new Node[nodeCnt + 1];

        for (int i = 0; i < nodeCnt - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int nodeNum = Integer.parseInt(st.nextToken());

            if (nodeArr[nodeNum] == null) {
                nodeArr[nodeNum] = new Node(nodeNum);
            }

            int toNodeNum = Integer.parseInt(st.nextToken());

            if (nodeArr[toNodeNum] == null) {
                nodeArr[toNodeNum] = new Node(toNodeNum);
            }
            int cost = Integer.parseInt(st.nextToken());

            nodeArr[nodeNum].addLine(new Node(toNodeNum, cost));
            nodeArr[toNodeNum].addLine(new Node(nodeNum, cost));
        }

        visited = new boolean[nodeCnt + 1];
        dfs(1, 0);

        visited = new boolean[nodeCnt + 1];
        dfs(endNode, 0);
        bw.write(String.valueOf(result));

        br.close();
        bw.close();
    }

    private void dfs(int idx, int value) {
        if (result < value) {
            result = value;
            endNode = idx;
        }

        visited[idx] = true;
        if (nodeArr[idx] != null) {
            for (Node n : nodeArr[idx].lineList) {
                if (!visited[n.idx]) {
                    dfs(n.idx, value + n.cost);
                }
            }
        }
    }

    class Node {
        int idx;
        int cost;
        List<Node> lineList;

        public Node(int idx_) {
            this.idx = idx_;
            this.lineList = new ArrayList<>();
        }
        public Node(int idx_, int cost_) {
            this.idx = idx_;
            this.cost = cost_;
        }

        public void addLine(Node n) {
            lineList.add(n);
        }
    }
}
