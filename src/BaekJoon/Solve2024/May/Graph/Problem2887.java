package BaekJoon.Solve2024.May.Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Problem2887 {
    int[] parent;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int nodeCnt = Integer.parseInt(br.readLine());
        List<Node> nodeList = new ArrayList<>();
        for (int i = 0; i < nodeCnt; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            nodeList.add(new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), i));
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a1, a2) -> a1[2] - a2[2]);

        // x축 정렬
        nodeList.sort((n1, n2) -> n1.x - n2.x);
        for (int i = 0; i < nodeList.size(); i++) {
            int now = nodeList.get(i).idx;
            int l = i - 1;
            if (l >= 0) {
                int next = nodeList.get(l).idx;
                pq.offer(new int[]{ now, next, Math.abs(nodeList.get(i).x - nodeList.get(l).x) });
            }

            int r = i + 1;
            if (r < nodeList.size()) {
                int next = nodeList.get(r).idx;
                pq.offer(new int[]{ now, next, Math.abs(nodeList.get(i).x - nodeList.get(r).x) });
            }
        }
        // y축 정렬
        nodeList.sort((n1, n2) -> n1.y - n2.y);
        for (int i = 0; i < nodeList.size(); i++) {
            int now = nodeList.get(i).idx;
            int l = i - 1;
            if (l >= 0) {
                int next = nodeList.get(l).idx;
                pq.offer(new int[]{ now, next, Math.abs(nodeList.get(i).y - nodeList.get(l).y) });
            }

            int r = i + 1;
            if (r < nodeList.size()) {
                int next = nodeList.get(r).idx;
                pq.offer(new int[]{ now, next, Math.abs(nodeList.get(i).y - nodeList.get(r).y) });
            }
        }
        // z축 정렬
        nodeList.sort((n1, n2) -> n1.z - n2.z);
        for (int i = 0; i < nodeList.size(); i++) {
            int now = nodeList.get(i).idx;
            int l = i - 1;
            if (l >= 0) {
                int next = nodeList.get(l).idx;
                pq.offer(new int[]{ now, next, Math.abs(nodeList.get(i).z - nodeList.get(l).z) });
            }

            int r = i + 1;
            if (r < nodeList.size()) {
                int next = nodeList.get(r).idx;
                pq.offer(new int[]{ now, next, Math.abs(nodeList.get(i).z - nodeList.get(r).z) });
            }
        }

        parent = new int[nodeCnt];
        for (int i = 0; i < nodeCnt; i++) {
            parent[i] = i;
        }

        int res = 0;
        while (!pq.isEmpty()) {
            int[] now = pq.poll();

            int from = now[0];
            int to = now[1];
            int cost = now[2];

            if (find(from) != find(to)) {
                union(from, to);
                res += cost;
            }
        }

        System.out.print(res);

        br.close();
    }

    private int find(int idx) {
        if (parent[idx] != idx) return find(parent[idx]);
        return idx;
    }

    private void union(int a, int b) {
        int root_a = find(a);
        int root_b = find(b);

        if (root_a != root_b) {
            if (root_a < root_b) {
                parent[root_b] = root_a;
            } else {
                parent[root_a] = root_b;
            }
        }
    }

    class Node {
        int x, y, z, idx;

        public Node(int x_, int y_, int z_, int idx_) {
            x = x_;
            y = y_;
            z = z_;
            idx = idx_;
        }
    }
}
