package BaekJoon.Solve2024.March.Sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class Problem2822 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Queue<int[]> q = new PriorityQueue<>((a1, a2) -> a2[1] - a1[1]);
        for (int i = 1; i <= 8; i++) {
            int score = Integer.parseInt(br.readLine());
            q.offer(new int[]{ i, score });
        }

        int sum = 0;
        Queue<Integer> resQ = new PriorityQueue<>();
        while (q.size() > 3) {
            int[] solved = q.poll();
            sum += solved[1];
            resQ.offer(solved[0]);
        }

        System.out.println(sum);
        while (!resQ.isEmpty()) {
            System.out.print(resQ.poll() + " ");
        }

        br.close();
    }
}
