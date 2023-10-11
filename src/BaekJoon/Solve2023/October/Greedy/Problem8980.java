package BaekJoon.Solve2023.October.Greedy;

import java.io.*;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Problem8980 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int capacity = Integer.parseInt(st.nextToken());

        int m = Integer.parseInt(br.readLine());
        PriorityQueue<int[]> que = new PriorityQueue<>((a1, a2) -> {
            if (a1[1] != a2[1]) return a1[1] - a2[1];
            return a1[0] - a2[0];
        });

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int amount = Integer.parseInt(st.nextToken());

            que.offer(new int[]{from, to, amount});
        }

        int res = 0;
        int[] truck = new int[n + 1];
        Arrays.fill(truck, capacity);
        while (!que.isEmpty()) {
            int[] baggage = que.poll();

            int amount = baggage[2];
            for (int i = baggage[0]; i < baggage[1]; i++) {
                amount = Math.min(amount, truck[i]);
            }

            for (int i = baggage[0]; i < baggage[1]; i++) {
                truck[i] -= amount;
            }
            res += amount;
        }

        bw.write(String.valueOf(res));

        br.close();
        bw.close();
    }
}
