package BaekJoon.Solve2023.November.DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Problem1655 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> minQue = new PriorityQueue<>((i1, i2) -> i1 - i2);
        PriorityQueue<Integer> maxQue = new PriorityQueue<>((i1, i2) -> i2 - i1);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());

            if (i == 0) {
                maxQue.offer(num);
            } else if (i == 1) {
                if (maxQue.peek() < num) {
                    minQue.offer(num);
                } else {
                    minQue.offer(maxQue.poll());
                    maxQue.offer(num);
                }
            } else {
                maxQue.offer(num);
                if (maxQue.peek() > minQue.peek()) {
                    maxQue.poll();
                    minQue.offer(num);
                    if (minQue.size() > maxQue.size()) {
                        maxQue.offer(minQue.poll());
                    }
                }

                if (maxQue.size() - minQue.size() > 1) {
                    minQue.offer(maxQue.poll());
                }
            }

            sb.append(maxQue.peek());
            sb.append("\n");
        }

        System.out.print(sb);

        br.close();
    }
}
