package BaekJoon.Solve2024.May.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Problem2576 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.comparingInt(i -> i));
        int sum = 0;
        for (int i = 0; i < 7; i++) {
            int num = Integer.parseInt(br.readLine());

            if (num % 2 == 1) {
                sum += num;
                pq.offer(num);
            }
        }

        if (pq.isEmpty()) {
            System.out.print("-1");
        } else {
            System.out.println(sum);
            System.out.print(pq.poll());
        }

        br.close();
    }
}
