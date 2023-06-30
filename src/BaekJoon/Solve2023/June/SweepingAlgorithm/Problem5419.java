package BaekJoon.Solve2023.June.SweepingAlgorithm;

import java.io.*;
import java.util.*;

public class Problem5419 {
    long[] segTree;
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int caseCnt = Integer.parseInt(br.readLine());
        for (int caseNum = 0; caseNum < caseCnt; caseNum++) {
            int islandCnt = Integer.parseInt(br.readLine());

            List<int[]> island = new ArrayList<>();
            for (int i = 0; i < islandCnt; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                island.add(new int[]{x, y});
            }
            island.sort((a1, a2) -> a1[1] - a2[1]);

            int rank = -1;
            int prev = Integer.MAX_VALUE;
            for (int i = 0; i < islandCnt; i++) {
                if (prev != island.get(i)[1]) rank++;
                prev = island.get(i)[1];
                island.get(i)[1] = rank;
            }
            island.sort((a1, a2) -> {
                if (a1[0] - a2[0] != 0) {
                    return a1[0] - a2[0];
                } else {
                    return a2[1] - a1[1];
                }
            });

            segTree = new long[islandCnt * 4];
            long result = 0;
            for (int i = 0; i < islandCnt; i++) {
                int[] now = island.get(i);
                result += select(0, islandCnt - 1, 1, now[1], islandCnt - 1);
                update(0, islandCnt - 1, 1, now[1]);
            }

            bw.write(String.valueOf(result));
            bw.newLine();
        }

        br.close();
        bw.close();
    }

    private void update(int start, int end, int node, int idx) {
        if (idx < start || end < idx) return;
        segTree[node]++;
        if (start == end) return;
        int mid = (start + end) / 2;
        update(start, mid, node * 2, idx);
        update(mid + 1, end, node * 2 + 1, idx);
    }

    private long select(int start, int end, int node, int left, int right) {
        if (end < left || right < start) return 0;
        if (left <= start && end <= right) return segTree[node];
        int mid = (start + end) / 2;
        return select(start, mid, node * 2, left, right) +
                select(mid + 1, end, node * 2 + 1, left, right);
    }
}
