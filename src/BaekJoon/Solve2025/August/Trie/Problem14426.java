package BaekJoon.Solve2025.August.Trie;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem14426 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        TrieNode root = new TrieNode();
        while (n-- > 0) {
            String word = br.readLine();
            root.insert(word, 0);
        }

        int res = 0;
        while (m-- > 0) {
            String word = br.readLine();
            if (root.search(word, 0)) res++;
        }
        System.out.print(res);

        br.close();
    }

    class TrieNode {
        TrieNode[] children;
        boolean isEnd;

        TrieNode() {
            children = new TrieNode[26];
            isEnd = false;
        }

        public void insert(String word, int idx) {
            if (idx >= word.length()) return;
            int next = word.charAt(idx) - 'a';
            if (children[next] == null) children[next] = new TrieNode();
            children[next].insert(word, idx + 1);
        }
        public boolean search(String word, int idx) {
            if (idx >= word.length()) return true;
            int next = word.charAt(idx) - 'a';
            if (children[next] == null) return false;
            return children[next].search(word, idx + 1);
        }
    }
}
