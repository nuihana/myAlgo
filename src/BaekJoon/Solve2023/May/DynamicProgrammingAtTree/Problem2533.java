package BaekJoon.Solve2023.May.DynamicProgrammingAtTree;

import java.io.*;
import java.util.*;

public class Problem2533 {
    Map<Integer, List<Integer>> relationMap;
    int[][] dp;
    final int INF = 1000000;
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int relationCnt = Integer.parseInt(br.readLine());
        relationMap = new HashMap<>();
        dp = new int[2][relationCnt + 1];
        Arrays.fill(dp[0], INF);
        Arrays.fill(dp[1], INF);

        for (int i = 0; i < relationCnt - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (relationMap.get(a) == null) {
                List<Integer> tmpList = new ArrayList<>();

                tmpList.add(b);

                relationMap.put(a, tmpList);
            } else {
                relationMap.get(a).add(b);
            }

            if (relationMap.get(b) == null) {
                List<Integer> tmpList = new ArrayList<>();

                tmpList.add(a);

                relationMap.put(b, tmpList);
            } else {
                relationMap.get(b).add(a);
            }
        }

        bw.write(String.valueOf(getMinInfluence(1, -1, true)));

        br.close();
        bw.close();
    }

    private int getMinInfluence(int idx, int parent, boolean parentIncluded) {
        if (dp[1][idx] < INF && !parentIncluded) {
            return dp[1][idx];
        }

        if (dp[1][idx] < INF && dp[0][idx] < INF && parentIncluded) {
            return Math.min(dp[1][idx], dp[0][idx]);
        }

        int include = 1;
        int notInclude = 0;

        if (relationMap.get(idx) != null) {
            for (int to : relationMap.get(idx)) {
                if (to != parent) {
                    include += getMinInfluence(to, idx, true);
                    notInclude += getMinInfluence(to, idx, false);
                }
            }
        }

        if (!parentIncluded) {
            return dp[1][idx] = include;
        } else {
            return dp[0][idx] = Math.min(include, notInclude);
        }
    }
}
