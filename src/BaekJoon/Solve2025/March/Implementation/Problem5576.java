package BaekJoon.Solve2025.March.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Problem5576 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        PriorityQueue<Integer> w = new PriorityQueue<>((i1, i2) -> i2 - i1);
        PriorityQueue<Integer> k = new PriorityQueue<>((i1, i2) -> i2 - i1);

        for (int i = 0; i < 10; i++) {
            int score = Integer.parseInt(br.readLine());
            w.offer(score);
        }

        for (int i = 0; i < 10; i++) {
            int score = Integer.parseInt(br.readLine());
            k.offer(score);
        }

        int wScore = 0;
        int kScore = 0;

        for (int i = 0; i < 3; i++) {
            wScore += w.poll();
            kScore += k.poll();
        }

        System.out.print(wScore + " " + kScore);

        br.close();
    }
}
