package BaekJoon.Solve2026.March.DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Problem15815 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String src = br.readLine();
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < src.length(); i++) {
            char c = src.charAt(i);
            if (c >= '0' && c <= '9') {
                stack.push(c - '0');
            } else {
                int tmp = stack.pop();
                if (c == '+') {
                    stack.push(stack.pop() + tmp);
                } else if (c == '-') {
                    stack.push(stack.pop() - tmp);
                } else if (c == '*') {
                    stack.push(stack.pop() * tmp);
                } else if (c == '/') {
                    stack.push(stack.pop() / tmp);
                }
            }
        }
        System.out.print(stack.pop());

        br.close();
    }
}
