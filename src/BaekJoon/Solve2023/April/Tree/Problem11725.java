package BaekJoon.Solve2023.April.Tree;

import java.io.*;
import java.util.*;

public class Problem11725 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int nodeCnt = Integer.parseInt(br.readLine());
        StringTokenizer st;

        Node[] nodeArr = new Node[nodeCnt + 1];
        for (int i = 0; i < nodeCnt - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int left = Integer.parseInt(st.nextToken());
            int right = Integer.parseInt(st.nextToken());

            if (nodeArr[left] == null) {
                nodeArr[left] = new Node(left);
            }

            if (nodeArr[right] == null) {
                nodeArr[right] = new Node(right);
            }

            nodeArr[left].setRight(nodeArr[right]);
            nodeArr[right].setLeft(nodeArr[left]);
        }

        int[] result = new int[nodeCnt + 1];
        boolean[] visited = new boolean[nodeCnt + 1];
        Queue<Node> que = new LinkedList<>();
        que.offer(nodeArr[1]);

        while(!que.isEmpty()) {
            Node tmp = que.poll();

            if (tmp.leftNode != null) {
                for (Node n : tmp.leftNode) {
                    if (!visited[n.idx]) {
                        visited[n.idx] = true;
                        result[n.idx] = tmp.idx;
                        que.add(n);
                    }
                }
            }

            if (tmp.rightNode != null) {
                for (Node n : tmp.rightNode) {
                    if (!visited[n.idx]) {
                        visited[n.idx] = true;
                        result[n.idx] = tmp.idx;
                        que.add(n);
                    }
                }
            }
        }

        for (int i = 2; i <= nodeCnt; i++) {
            bw.write(String.valueOf(result[i]));
            bw.newLine();
        }

        br.close();
        bw.close();
    }

    class Node {
        int idx;
        List<Node> leftNode;
        List<Node> rightNode;

        public Node(int idx_) {
            this.idx = idx_;
        }

        public void setLeft(Node n) {
            if (leftNode == null) {
                List<Node> tmpList = new ArrayList<>();

                tmpList.add(n);

                this.leftNode = tmpList;
            } else {
                leftNode.add(n);
            }
        }
        public void setRight(Node n) {
            if (rightNode == null) {
                List<Node> tmpList = new ArrayList<>();

                tmpList.add(n);

                this.rightNode = tmpList;
            } else {
                rightNode.add(n);
            }
        }
    }
}
