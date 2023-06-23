package BaekJoon.Solve2023.June.Greedy;

import java.io.*;
import java.util.*;

public class Problem1202 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int jewelCnt = Integer.parseInt(st.nextToken());
        int bagCnt = Integer.parseInt(st.nextToken());

        int[][] jewel = new int[jewelCnt][2]; // 0 : 무게, 1: 가치
        for (int i = 0; i < jewelCnt; i++) {
            st = new StringTokenizer(br.readLine());

            jewel[i][0] = Integer.parseInt(st.nextToken());
            jewel[i][1] = Integer.parseInt(st.nextToken());
        }

        int[] bag = new int[bagCnt];
        for (int i = 0; i < bagCnt; i++) {
            bag[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(jewel, (a1, a2) -> a1[0] - a2[0]);
        Arrays.sort(bag);

        long tot = 0;
        int idx = 0;
        PriorityQueue<int[]> que = new PriorityQueue<>((a1, a2) -> a2[1] - a1[1]);
        for (int i = 0; i < bagCnt; i++) {
            while (idx < jewelCnt && jewel[idx][0] <= bag[i]) {
                que.offer(jewel[idx++]);
            }

            if (!que.isEmpty()) {
                tot += que.poll()[1];
            }
        }

        bw.write(String.valueOf(tot));

        br.close();
        bw.close();
    }
}
