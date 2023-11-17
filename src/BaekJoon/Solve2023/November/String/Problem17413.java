package BaekJoon.Solve2023.November.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Problem17413 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String src = br.readLine();

        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        Queue<Character> que = new LinkedList<>();
        for (int i = 0; i < src.length(); i++) {
            char c = src.charAt(i);
            if (c == '<') {
                if (!stack.isEmpty()) {
                    while (!stack.isEmpty()) {
                        sb.append(stack.pop());
                    }
                }
                que.offer(c);
                continue;
            }
            if (c == '>') {
                que.offer(c);
                while (!que.isEmpty()) {
                    sb.append(que.poll());
                }
                continue;
            }
            if (c == ' ') {
                while (!stack.isEmpty()) {
                    sb.append(stack.pop());
                }
                sb.append(c);
                continue;
            }

            if (que.isEmpty()) stack.push(c);
            else que.offer(c);
        }
        if (!stack.isEmpty()) {
            while (!stack.isEmpty()) {
                sb.append(stack.pop());
            }
        }

        System.out.print(sb);

        br.close();
    }
}
