package BaekJoon.Solve2023.October.Greedy;

import java.io.*;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Problem13975 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int k = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            PriorityQueue<Long> que = new PriorityQueue<>(Comparator.comparingLong(l -> l));
            while (st.hasMoreTokens()) {
                long cost = Long.parseLong(st.nextToken());
                que.offer(cost);
            }

            long finalCost = 0;
            while (true) {
                long now = que.poll();
                if (que.isEmpty()) break;
                long next = que.poll();
                finalCost += now + next;
                que.offer(now + next);
            }

            bw.write(String.valueOf(finalCost));
            bw.newLine();
        }

        br.close();
        bw.close();
    }
}
