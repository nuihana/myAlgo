package BaekJoon.Solve2026.January.DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem2696 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            int m = Integer.parseInt(br.readLine());
            sb.append(m / 2 + 1).append("\n");

            StringTokenizer st = null;
            PriorityQueue<Integer> largeQ = new PriorityQueue<>((i1, i2) -> Integer.compare(i1, i2));
            PriorityQueue<Integer> smallQ = new PriorityQueue<>((i1, i2) -> Integer.compare(i2, i1));
            for (int i = 0, j = 1; i < m; i++) {
                if (i % 10 == 0) st = new StringTokenizer(br.readLine());
                int cur = Integer.parseInt(st.nextToken());

                if (largeQ.size() == smallQ.size()) largeQ.offer(cur);
                else smallQ.offer(cur);

                if (!largeQ.isEmpty() && !smallQ.isEmpty()) {
                    if (smallQ.peek() > largeQ.peek()) {
                        int tmp = smallQ.poll();
                        smallQ.offer(largeQ.poll());
                        largeQ.offer(tmp);
                    }
                }

                if (i % 2 == 0) {
                    sb.append(largeQ.peek()).append(" ");
                    if (j % 10 == 0) sb.append("\n");
                    j++;
                }
            }

            sb.append("\n");
        }
        System.out.print(sb);

        br.close();
    }
}
