package BaekJoon.Solve2023.June.Greedy;

import java.io.*;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Problem1715 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int cardCnt = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> que = new PriorityQueue<>((i1, i2) -> i1 - i2);
        for (int i = 0; i < cardCnt; i++) {
            que.offer(Integer.parseInt(br.readLine()));
        }

        long result = 0;
        while(!que.isEmpty()) {
            int num1 = que.poll();
            if (que.isEmpty()) {
                break;
            }
            int num2 = que.poll();

            result += num1 + num2;
            que.offer(num1 + num2);
        }

        bw.write(String.valueOf(result));

        br.close();
        bw.close();
    }
}
