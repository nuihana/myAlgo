package BaekJoon.Solve2023.April.Random;

import java.io.*;
import java.util.Stack;

public class Problem1918 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();

        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            char tmp = str.charAt(i);

            if (tmp == '*' || tmp == '/' || tmp == '+' || tmp == '-' || tmp == '(' || tmp == ')') {
                if (tmp == '(') {
                    stack.push(tmp);
                    continue;
                }

                if (tmp == ')') {
                    while (stack.peek() != '(') {
                        sb.append(stack.pop());
                    }
                    stack.pop();
                    continue;
                }

                while (!stack.isEmpty() && getPriority(stack.peek()) >= getPriority(tmp)) {
                    sb.append(stack.pop());
                }

                stack.push(tmp);
            } else {
                sb.append(tmp);
            }
        }

        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        bw.write(sb.toString());

        br.close();
        bw.close();
    }

    private int getPriority(char c) {
        if (c == '*' || c == '/') {
            return 2;
        }

        if (c == '+' || c == '-') {
            return 1;
        }

        return 0;
    }
}
