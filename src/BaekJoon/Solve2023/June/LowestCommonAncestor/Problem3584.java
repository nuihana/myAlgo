package BaekJoon.Solve2023.June.LowestCommonAncestor;

import java.io.*;
import java.util.*;

public class Problem3584 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int caseCnt = Integer.parseInt(br.readLine());
        for (int i = 0; i < caseCnt; i++) {
            int nodeCnt = Integer.parseInt(br.readLine());
            int[] parentTable = new int[nodeCnt + 1];
            for (int j = 1; j <= nodeCnt; j++) {
                parentTable[j] = j;
            }

            StringTokenizer st;
            for (int j = 0; j < nodeCnt - 1; j++) {
                st = new StringTokenizer(br.readLine());
                int parent = Integer.parseInt(st.nextToken());
                int child = Integer.parseInt(st.nextToken());

                parentTable[child] = parent;
            }

            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            List<Integer> aList = new ArrayList<>();
            List<Integer> bList = new ArrayList<>();

            while(parentTable[a] != a) {
                aList.add(a);
                a = parentTable[a];
            }
            aList.add(a);
            while(parentTable[b] != b) {
                bList.add(b);
                b = parentTable[b];
            }
            bList.add(b);

            while(aList.size() != bList.size()) {
                if (aList.size() > bList.size()) {
                    aList.remove(0);
                } else {
                    bList.remove(0);
                }
            }

            for (int j = 0; j < aList.size(); j++) {
                if ((int) aList.get(j) == bList.get(j)) {
                    bw.write(String.valueOf(aList.get(j)));
                    bw.newLine();
                    break;
                }
            }
        }

        br.close();
        bw.close();
    }
}
