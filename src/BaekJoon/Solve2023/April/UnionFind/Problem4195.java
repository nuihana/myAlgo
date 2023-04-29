package BaekJoon.Solve2023.April.UnionFind;

import java.io.*;
import java.util.*;

public class Problem4195 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int caseCnt = Integer.parseInt(br.readLine());

        for (int i = 0; i < caseCnt; i++) {
            int relCnt = Integer.parseInt(br.readLine());

            UnionFind uf = new UnionFind();

            for (int j = 0; j < relCnt; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());

                String a = st.nextToken();
                String b = st.nextToken();

                uf.union(a, b);
                bw.write(uf.getNetSize(a));
                bw.newLine();
            }
        }

        br.close();
        bw.close();
    }

    class UnionFind {
        List<Integer> valList;
        HashMap<String, Integer> idMap;
        HashMap<Integer, Integer> networkCnt;

        public UnionFind() {
            valList = new ArrayList<>();
            idMap = new HashMap<>();
            networkCnt = new HashMap<>();
            valList.add(0);
        }

        private int findRoot(int idx) {
            while (idx != valList.get(idx)) {
                idx = valList.get(idx);
            }

            return idx;
        }
        private boolean contains(String target) {
            if (idMap.get(target) == null) {
                return false;
            }

            return true;
        }
        private int getID(String target) {
            if (!contains(target)) {
                idMap.put(target, valList.size());

                valList.add(valList.size());
            }

            return idMap.get(target);
        }

        public void union(String parent, String child) {
            int root = findRoot(getID(parent));
            int child_root = findRoot(getID(child));

            valList.set(child_root, root);

            if (root != child_root) {
                int childNet = networkCnt.get(child_root) == null ? 1 : networkCnt.get(child_root);
                if (networkCnt.get(root) == null) {
                    networkCnt.put(root, 1 + childNet);
                } else {
                    networkCnt.put(root, networkCnt.get(root) + childNet);
                }
            }
        }
        public int getNetSize(String target) {
            int root = findRoot(getID(target));

            return networkCnt.get(root);
        }
    }
}
