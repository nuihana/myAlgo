package BaekJoon.Solve2024.May.Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Problem2250 {
    int idx = 1;
    List<Integer>[] level;
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int nodeCnt = Integer.parseInt(br.readLine());
        Node[] tree = new Node[nodeCnt + 1];
        level = new List[nodeCnt + 1];
        for (int i = 1; i <= nodeCnt; i++) {
            tree[i] = new Node(i);
            level[i] = new ArrayList<>();
        }

        int root = -1;
        boolean[] isNotRoot = new boolean[nodeCnt + 1];
        for (int i = 0; i < nodeCnt; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int id = Integer.parseInt(st.nextToken());
            int left = Integer.parseInt(st.nextToken());
            int right = Integer.parseInt(st.nextToken());

            if (left > 0) {
                isNotRoot[left] = true;
                tree[id].setLeft(tree[left]);
            }
            if (right > 0) {
                isNotRoot[right] = true;
                tree[id].setRight(tree[right]);
            }
        }

        for (int i = 1; i <= nodeCnt; i++) {
            if (!isNotRoot[i]) {
                root = i;
                break;
            }
        }

        dfs(tree[root], 1);
        int depth = -1;
        int width = -1;
        for (int i = 1; i <= nodeCnt; i++) {
            level[i].sort(Comparator.naturalOrder());
            if (level[i].isEmpty()) continue;
            int thisWidth = level[i].get(level[i].size() - 1) - level[i].get(0);
            if (thisWidth > width) {
                width = thisWidth;
                depth = i;
            }
        }

        System.out.print(depth + " " + (width + 1));

        br.close();
    }

    private void dfs(Node now, int depth) {
        if (now.left != null) dfs(now.left, depth + 1);
        level[depth].add(idx++);
        if (now.right != null) dfs(now.right, depth + 1);
    }

    class Node {
        int idx;
        Node left;
        Node right;

        public Node(int id) {
            idx = id;
        }

        public void setLeft(Node node) {
            left = node;
        }
        public void setRight(Node node) {
            right = node;
        }
    }
}
