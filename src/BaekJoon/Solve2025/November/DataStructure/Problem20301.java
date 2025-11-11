package BaekJoon.Solve2025.November.DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Problem20301 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 1; i <= n; i++) deque.add(i);

        StringBuilder sb = new StringBuilder();
        int nth = 0, direction = 1;
        while (!deque.isEmpty()) {
            for (int i = 0; i < k - 1; i++) {
                if (direction == 1) {
                    deque.addLast(deque.pollFirst());
                } else {
                    deque.addFirst(deque.pollLast());
                }
            }

            if (direction == 1) {
                sb.append(deque.pollFirst()).append("\n");
            } else {
                sb.append(deque.pollLast()).append("\n");
            }

            nth++;
            if (nth == m) {
                direction *= -1;
                nth = 0;
            }
        }
        System.out.print(sb);

        br.close();
    }
}
