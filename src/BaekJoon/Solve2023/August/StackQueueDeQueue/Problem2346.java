package BaekJoon.Solve2023.August.StackQueueDeQueue;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Problem2346 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        Deque<Integer> deque = new ArrayDeque<>();
        int[] arr = new int[n + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            deque.addLast(i);
        }

        boolean flag = true;

        while (!deque.isEmpty()) {
            int i;
            if (flag) {
                i = deque.pollFirst();
            } else {
                i = deque.pollLast();
            }

            bw.write(i + " ");

            if (deque.isEmpty()) break;

            if (arr[i] > 0) {
                flag = true;
                while(arr[i]-- > 1) {
                    deque.addLast(deque.pollFirst());
                }
            } else {
                flag = false;
                while(arr[i]++ < -1) {
                    deque.addFirst(deque.pollLast());
                }
            }
        }

        br.close();
        bw.close();
    }
}
