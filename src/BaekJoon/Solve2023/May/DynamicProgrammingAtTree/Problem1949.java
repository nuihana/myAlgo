package BaekJoon.Solve2023.May.DynamicProgrammingAtTree;

import java.io.*;
import java.util.*;

public class Problem1949 {
    int[] citizen;
    Map<Integer, List<Integer>> pathMap;
    int[][] dp;
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int cityCnt = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        citizen = new int[cityCnt + 1];
        for (int i = 1; i <= cityCnt; i++) {
            citizen[i] = Integer.parseInt(st.nextToken());
        }

        pathMap = new HashMap<>();
        for (int i = 0; i < cityCnt - 1; i++) {
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

        dp = new int[cityCnt + 1][2];
        bw.write(String.valueOf(memoization(1, -1, false)));

        br.close();
        bw.close();
    }

    private int memoization(int currentIdx, int parentIdx, boolean parentIncluded) {
        if (dp[currentIdx][0] > 0 && parentIncluded) {
            return dp[currentIdx][0];
        }

        if (dp[currentIdx][0] > 0 && dp[currentIdx][1] > 0 && !parentIncluded) {
            return Math.max(dp[currentIdx][0], dp[currentIdx][1]);
        }

        int include = citizen[currentIdx];
        int notInclude = 0;

        if (pathMap.get(currentIdx) != null) {
            for (int to : pathMap.get(currentIdx)) {
                if (to != parentIdx) {
                    include += memoization(to, currentIdx, true);
                    notInclude += memoization(to, currentIdx, false);
                }
            }
        }

        if (parentIncluded) {
            return dp[currentIdx][0] = notInclude;
        } else {
            return dp[currentIdx][1] = Math.max(include, notInclude);
        }
    }
}
