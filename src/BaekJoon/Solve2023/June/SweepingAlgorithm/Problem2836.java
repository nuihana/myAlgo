package BaekJoon.Solve2023.June.SweepingAlgorithm;

import java.io.*;
import java.util.*;

public class Problem2836 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int nodeCnt = Integer.parseInt(st.nextToken());
        long finalIdx = Long.parseLong(st.nextToken());

        List<int[]> reverseList = new ArrayList<>();
        for (int i = 0; i < nodeCnt; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (a > b) {
                reverseList.add(new int[]{b, a});
            }
        }

        reverseList.sort((a1, a2) -> a1[0] - a2[0]);
        int left = 0;
        int right = 0;
        int returnLength = 0;
        for (int[] next : reverseList) {
            if (next[0] > right) {
                returnLength += (right - left) * 2;
                left = next[0];
            }
            right = Math.max(right, next[1]);
        }
        returnLength += (right - left) * 2;

        bw.write(String.valueOf(finalIdx + returnLength));

        br.close();
        bw.close();
    }
}
