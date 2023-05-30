package BaekJoon.Solve2023.May.StringAlgorithm1;

import java.io.*;
import java.util.*;

public class Problem14725 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int leafCnt = Integer.parseInt(br.readLine());

        Trie trie = new Trie(0); // root
        for (int i = 0; i < leafCnt; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int nodeCnt = Integer.parseInt(st.nextToken());

            Trie tmp = trie;
            for (int j = 0; j < nodeCnt; j++) {
                String str = st.nextToken();

                tmp = tmp.setString(str);
            }
        }

        bw.write(trie.print());

        br.close();
        bw.close();
    }

    class Trie {
        Map<String, Trie> value;
        int depth;

        public Trie(int depth_) {
            value = new HashMap<>();
            this.depth = depth_;
        }

        private String header() {
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < depth; i++) {
                sb.append("--");
            }

            return sb.toString();
        }

        public Trie setString(String str) {
            if (value.get(str) == null) {
                Trie tmp = new Trie(depth + 1);
                value.put(str, tmp);
            }

            return value.get(str);
        }
        public String print() {
            StringBuilder sb = new StringBuilder();

            List<String> keyList = new ArrayList<>(value.keySet());
            keyList.sort(Comparator.naturalOrder());

            for (String key : keyList) {
                sb.append(header()).append(key).append("\n");
                if (value.get(key) != null) {
                    sb.append(value.get(key).print());
                }
            }

            return sb.toString();
        }
    }
}
