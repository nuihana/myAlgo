package BaekJoon.Solve2023.March.PriorityQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Problem11286 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int commandCnt = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {

                return Math.abs(o1) - Math.abs(o2) == 0 ? o1 - o2 : Math.abs(o1) - Math.abs(o2);
            }
        });

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