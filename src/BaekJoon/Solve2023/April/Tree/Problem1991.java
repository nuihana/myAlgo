package BaekJoon.Solve2023.April.Tree;

import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Problem1991 {
    Tree tree;
    StringBuilder sb;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int nodeCnt = Integer.parseInt(br.readLine());
        tree = new Tree();

        for (int i = 0; i < nodeCnt; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            String value = st.nextToken();
            String left = st.nextToken();
            String right = st.nextToken();

            Node node;

            if (tree.getNode(value) != null) {
                node = tree.getNode(value);
            } else {
                node = new Node(value);
            }

            if (!left.equals(".")) {
                Node tmp = new Node(left);
                tree.setNode(tmp);
                node.setLeft(tmp);
            }

            if (!right.equals(".")) {
                Node tmp = new Node(right);
                tree.setNode(tmp);
                node.setRight(tmp);
            }

            if (i == 0) {
                tree.setRootNode(node);
            }
        }

        sb = new StringBuilder();
        preOrder(tree.getRootNode());
        bw.write(sb.toString());

        bw.newLine();

        sb = new StringBuilder();
        inOrder(tree.getRootNode());
        bw.write(sb.toString());

        bw.newLine();

        sb = new StringBuilder();
        postOrder(tree.getRootNode());
        bw.write(sb.toString());

        br.close();
        bw.close();
    }

    private void preOrder(Node node) {
        sb.append(node.value);

        if (node.left != null) {
            preOrder(node.left);
        }

        if (node.right != null) {
            preOrder(node.right);
        }
    }

    private void inOrder(Node node) {
        if (node.left != null) {
            inOrder(node.left);
        }

        sb.append(node.value);

        if (node.right != null) {
            inOrder(node.right);
        }
    }

    private void postOrder(Node node) {
        if (node.left != null) {
            postOrder(node.left);
        }

        if (node.right != null) {
            postOrder(node.right);
        }

        sb.append(node.value);
    }

    class Tree {
        Node rootNode;
        HashMap<String, Node> treeIdx = new HashMap<>();

        public void setRootNode(Node root) {
            this.rootNode = root;
            this.treeIdx.put(root.value, root);
        }
        public Node getRootNode() {
            return rootNode;
        }
        public Node getNode(String key) {
            return treeIdx.get(key);
        }
        public void setNode(Node node) {
            this.treeIdx.put(node.value, node);
        }
    }

    class Node {
        String value;
        Node left;
        Node right;

        public Node(String str) {
            this.value = str;
        }

        public void setLeft(Node node) {
            this.left = node;
        }
        public void setRight(Node node) {
            this.right = node;
        }
    }
}
