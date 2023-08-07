package BaekJoon.Solve2023.August.StackQueueDeQueue;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Problem24511 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        boolean[] isQueue = new boolean[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int in = Integer.parseInt(st.nextToken());
            if (in == 0) isQueue[i] = true;
        }

        Stack<Integer> stack = new Stack<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int in = Integer.parseInt(st.nextToken());
            if (isQueue[i]) stack.push(in);
        }

        Queue<Integer> que = new LinkedList<>();
        while (!stack.isEmpty()) {
            que.add(stack.pop());
        }

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            int in = Integer.parseInt(st.nextToken());
            que.add(in);
        }

        for (int i = 0; i < m; i++) {
            bw.write(String.valueOf(que.poll()));
            bw.write(" ");
        }

        br.close();
        bw.close();
    }
}
