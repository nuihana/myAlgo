package BaekJoon.Solve2023.March.PriorityQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Problem11279 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int commandCnt = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < commandCnt; i++) {
            int command = Integer.parseInt(br.readLine());

            if (command == 0) {
                System.out.println(queue.size() == 0 ? 0 : queue.poll());
            } else {
                queue.add(command);
            }
        }

        br.close();
    }
}