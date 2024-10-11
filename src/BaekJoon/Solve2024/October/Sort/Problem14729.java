package BaekJoon.Solve2024.October.Sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

public class Problem14729 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        PriorityQueue<String> pq = new PriorityQueue<>((s1, s2) -> Float.compare(Float.parseFloat(s2), Float.parseFloat(s1)));
        while (n-- > 0) {
            String now = br.readLine();

            if (pq.size() < 7) {
                pq.offer(now);
            } else {
                String last = pq.peek();
                if (Float.compare(Float.parseFloat(last), Float.parseFloat(now)) > 0) {
                    pq.poll();
                    pq.offer(now);
                }
            }
        }

        Stack<String> stack = new Stack<>();
        while (!pq.isEmpty()) stack.push(pq.poll());
        for (int i = 0; i < 7; i++) {
            System.out.println(stack.pop());
        }

        br.close();
    }
}
