package BaekJoon.Solve2023.June.String;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Problem5052 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int caseCnt = Integer.parseInt(br.readLine());
        for (int i = 0; i < caseCnt; i++) {
            int callCnt = Integer.parseInt(br.readLine());

            String[] arr = new String[callCnt];
            for (int j = 0; j < callCnt; j++) {
                arr[j] = br.readLine();
            }

            Trie tree = new Trie();
            String ans = "YES";
            Arrays.sort(arr);
            for (int j = 0; j < callCnt; j++) {
                if (tree.setValue(arr[j])) {
                    ans = "NO";
                }
            }

            bw.write(ans);
            bw.newLine();
        }

        br.close();
        bw.close();
    }

    class Trie {
        Map<Character, Trie> data;
        boolean isEnd;

        public Trie() {
            data = new HashMap<>();
            isEnd = false;
        }

        public boolean setValue(String str) {
            Trie node = this;
            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);

                if (!node.data.containsKey(c))
                    node.data.put(c, new Trie());

                node = node.data.get(c);
                if (node.isEnd) return true;
            }

            node.isEnd = true;
            return false;
        }
    }
}
