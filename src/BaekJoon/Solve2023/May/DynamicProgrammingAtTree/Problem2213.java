package BaekJoon.Solve2023.May.DynamicProgrammingAtTree;

import java.io.*;
import java.util.*;

public class Problem2213 {
    int[][] dp;
    Map<Integer, List<Integer>> pathMap;
    int[] nodeValueArr;
    List<Integer> indSet = new ArrayList<>();
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int nodeCnt = Integer.parseInt(br.readLine());
        nodeValueArr = new int[nodeCnt + 1];
        dp = new int[nodeCnt + 1][2];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= nodeCnt; i++) {
            nodeValueArr[i] = Integer.parseInt(st.nextToken());
        }

        pathMap = new HashMap<>();
        for (int i = 0; i < nodeCnt - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (pathMap.get(a) == null) {
                List<Integer> tmpList = new ArrayList<>();

                tmpList.add(b);

                pathMap.put(a, tmpList);
            } else {
                pathMap.get(a).add(b);
            }

            if (pathMap.get(b) == null) {
                List<Integer> tmpList = new ArrayList<>();

                tmpList.add(a);

                pathMap.put(b, tmpList);
            } else {
                pathMap.get(b).add(a);
            }
        }

        bw.write(String.valueOf(memoization(1, -1, false)));
        bw.newLine();

        backTracking(1, -1);
        Collections.sort(indSet);
        for (int i = 0; i < indSet.size(); i++) {
            bw.write(indSet.get(i) + " ");
        }

        br.close();
        bw.close();
    }

    private int memoization(int currentIdx, int parentIdx, boolean parentIncluded) {
        if (parentIncluded && dp[currentIdx][1] > 0) {
            return dp[currentIdx][1];
        }

        if (!parentIncluded && dp[currentIdx][0] > 0 && dp[currentIdx][1] > 0) {
            return Math.max(dp[currentIdx][0], dp[currentIdx][1]);
        }

        int include = nodeValueArr[currentIdx];
        int notInclude = 0;

        if (pathMap.get(currentIdx) != null) {
            for (int to : pathMap.get(currentIdx)) {
                if (to != parentIdx) { // parent 가 아닌 간선
                    include += memoization(to, currentIdx, true);
                    notInclude += memoization(to, currentIdx, false);
                }
            }
        }

        dp[currentIdx][0] = Math.max(dp[currentIdx][0], notInclude);
        dp[currentIdx][1] = Math.max(dp[currentIdx][1], include);

        if (parentIncluded) {
            return dp[currentIdx][0];
        } else {
            return Math.max(dp[currentIdx][0], dp[currentIdx][1]);
        }
    }

    private void backTracking(int idx, int parent) {
        if (dp[idx][1] > dp[idx][0] && !indSet.contains(parent)) {
            indSet.add(idx);
        }

        if (pathMap.get(idx) != null) {
            for (int to : pathMap.get(idx)) {
                if (to != parent) {
                    backTracking(to, idx);
                }
            }
        }
    }
}
