package BaekJoon.Solve2025.July.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Problem21756 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            q.offer(i);
        }

        while (q.size() > 1) {
            Queue<Integer> next = new LinkedList<>();
            int ord = 1;
            while (!q.isEmpty()) {
                int now = q.poll();
                if (ord++ % 2 == 0) {
                    next.offer(now);
                }
            }

            q = next;
        }

        System.out.print(q.poll());

        br.close();
    }
}
