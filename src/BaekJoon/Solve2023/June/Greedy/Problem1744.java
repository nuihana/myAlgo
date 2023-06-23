package BaekJoon.Solve2023.June.Greedy;

import java.io.*;
import java.util.PriorityQueue;

public class Problem1744 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int numCnt = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pque = new PriorityQueue<>((i1, i2) -> i2 - i1);
        PriorityQueue<Integer> mque = new PriorityQueue<>((i1, i2) -> i1 - i2);
        for (int i = 0; i < numCnt; i++) {
            int num = Integer.parseInt(br.readLine());
            if (num > 0) {
                pque.offer(num);
            } else {
                mque.offer(num);
            }
        }

        int result = 0;
        while(!pque.isEmpty()) {
            int num1 = pque.poll();

            if(pque.isEmpty()) {
                result += num1;
                break;
            }
            int num2 = pque.poll();

            if (num1 * num2 > num1 + num2) {
                result += (num1 * num2);
            } else {
                result += num1;
                pque.offer(num2);
            }
        }

        while(!mque.isEmpty()) {
            int num1 = mque.poll();

            if(mque.isEmpty()) {
                result += num1;
                break;
            }
            int num2 = mque.poll();

            if (num1 * num2 > num1 + num2) {
                result += (num1 * num2);
            } else {
                result += num1;
                mque.offer(num2);
            }
        }

        bw.write(String.valueOf(result));

        br.close();
        bw.close();
    }
}
