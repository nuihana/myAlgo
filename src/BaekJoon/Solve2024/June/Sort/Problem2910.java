package BaekJoon.Solve2024.June.Sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Problem2910 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int numCnt = Integer.parseInt(st.nextToken());
        int max = Integer.parseInt(st.nextToken());

        Map<Integer, int[]> map = new HashMap<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < numCnt; i++) {
            int num = Integer.parseInt(st.nextToken());

            if (!map.containsKey(num)) map.put(num, new int[]{ i, 0 });
            map.get(num)[1]++;
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a1, a2) -> {
            if (a1[2] != a2[2]) return a2[2] - a1[2];
            return a1[1] - a2[1];
        });
        for (int key : map.keySet()) {
            pq.offer(new int[]{ key, map.get(key)[0], map.get(key)[1] });
        }

        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            int[] item = pq.poll();

            for (int i = 0; i < item[2]; i++) {
                sb.append(item[0]).append(" ");
            }
        }

        System.out.print(sb);

        br.close();
    }
}
