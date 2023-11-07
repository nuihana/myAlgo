package BaekJoon.Solve2023.November.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Problem9250 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        TrieNode root = new TrieNode();
        for (int i = 0; i < n; i++) {
            root.insert(br.readLine());
        }

        root.computeFail();

        StringBuilder sb = new StringBuilder();
        int q = Integer.parseInt(br.readLine());
        for (int i = 0; i < q; i++) {
            if (root.ahoCorasick(br.readLine())) {
                sb.append("YES").append("\n");
            } else {
                sb.append("NO").append("\n");
            }
        }
        System.out.println(sb);

        br.close();
    }

    class TrieNode {
        Map<Character, TrieNode> child = new HashMap<>();
        TrieNode fail;
        boolean isEnd = false;

        public void insert(String word) {
            TrieNode cur = this;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);

                cur.child.putIfAbsent(c, new TrieNode());
                cur = cur.child.get(c);
            }
            cur.isEnd = true;
        }

        public void computeFail() {
            Queue<TrieNode> que = new LinkedList<>();
            this.fail = this;
            que.offer(this);

            while (!que.isEmpty()) {
                TrieNode cur = que.poll();
                for (int i = 0; i < 26; i++) {
                    char c = (char) ('a' + i);

                    TrieNode next = cur.child.get(c);
                    if (next == null) continue;

                    if (cur == this) {
                        next.fail = this;
                    } else {
                        TrieNode failNode = cur.fail;
                        while (failNode != this && failNode.child.get(c) == null) failNode = failNode.fail;
                        if (failNode.child.get(c) != null) failNode = failNode.child.get(c);
                        next.fail = failNode;
                    }

                    if (next.fail.isEnd) {
                        next.isEnd = true;
                    }
                    que.offer(next);
                }
            }
        }

        public boolean ahoCorasick(String word) {
            TrieNode cur = this;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                while (cur != this && cur.child.get(c) == null) cur = cur.fail;
                if (cur.child.get(c) != null) cur = cur.child.get(c);
                if (cur.isEnd) return true;
            }
            return false;
        }
    }
}
