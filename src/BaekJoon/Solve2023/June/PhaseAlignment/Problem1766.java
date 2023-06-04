package BaekJoon.Solve2023.June.PhaseAlignment;

import java.io.*;
import java.util.*;

public class Problem1766 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int questCnt = Integer.parseInt(st.nextToken());
        int conditionCnt = Integer.parseInt(st.nextToken());

        int[] questArr = new int[questCnt + 1];
        Map<Integer, List<Integer>> conditionMap = new HashMap<>();
        for (int i = 1; i <= questCnt; i++) {
            conditionMap.put(i, new ArrayList<>());
        }

        for (int i = 0; i < conditionCnt; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            conditionMap.get(a).add(b);
            questArr[b]++;
        }

        PriorityQueue<Integer> que = new PriorityQueue<>((i1, i2) -> i1 - i2);
        for (int i = 1; i <= questCnt; i++) {
            if (questArr[i] == 0) {
                que.offer(i);
            }
        }

        StringBuilder sb = new StringBuilder();
        while(!que.isEmpty()) {
            int now = que.poll();

            for (int next : conditionMap.get(now)) {
                questArr[next]--;

                if (questArr[next] == 0) {
                    que.offer(next);
                }
            }

            sb.append(now).append(" ");
        }

        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}
