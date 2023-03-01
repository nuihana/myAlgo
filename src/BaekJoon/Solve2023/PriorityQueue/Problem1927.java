package BaekJoon.Solve2023.PriorityQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Problem1927 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int commandCnt = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> queue = new PriorityQueue<>();

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