package BaekJoon.Solve2023.May.DynamicProgrammingAtTree;

import java.io.*;
import java.util.*;

public class Problem15681 {
    Map<Integer, List<Integer>> edgeMap;
    int[] dp;
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int nodeCnt = Integer.parseInt(st.nextToken());
        int rootNodeIdx = Integer.parseInt(st.nextToken());
        int queryCnt = Integer.parseInt(st.nextToken());

        edgeMap = new HashMap<>();
        //간선 조건
        for (int i = 0; i < nodeCnt - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (edgeMap.get(a) == null) {
                List<Integer> tmpList = new ArrayList<>();

                tmpList.add(b);

                edgeMap.put(a, tmpList);
            } else {
                edgeMap.get(a).add(b);
            }

            if (edgeMap.get(b) == null) {
                List<Integer> tmpList = new ArrayList<>();

                tmpList.add(a);

                edgeMap.put(b, tmpList);
            } else {
                edgeMap.get(b).add(a);
            }
        }

        dp = new int[nodeCnt + 1];
        setTree(rootNodeIdx, -1);

        //질의
        for (int i = 0; i < queryCnt; i++) {
            int queryRoot = Integer.parseInt(br.readLine());

            bw.write(String.valueOf(dp[queryRoot]));
            bw.newLine();
        }

        br.close();
        bw.close();
    }

    private int setTree(int currentNode, int parentNode) {
        int childCnt = 1;
        if (edgeMap.get(currentNode) != null) {
            for (int linkedNode : edgeMap.get(currentNode)) {
                if (linkedNode != parentNode) {
                    childCnt += setTree(linkedNode, currentNode);
                }
            }
        }
        return dp[currentNode] = childCnt;
    }
}
