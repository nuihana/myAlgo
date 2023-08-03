package BaekJoon.Solve2023.August.StackQueueDeQueue;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Problem12789 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Stack<Integer> wait = new Stack<>();

        int now = 1;
        int waitIdx = 0;
        boolean flag = true;
        while (flag && now < n) {
            if (!wait.isEmpty() && wait.peek() == now) {
                now++;
                wait.pop();
                continue;
            }

            while (waitIdx < n && arr[waitIdx] != now) {
                wait.push(arr[waitIdx]);
                waitIdx++;
            }

            if (waitIdx < n && arr[waitIdx] == now) {
                waitIdx++;
                now++;
            } else {
                flag = false;
            }
        }

        if (flag) {
            bw.write("Nice");
        } else {
            bw.write("Sad");
        }

        br.close();
        bw.close();
    }
}
