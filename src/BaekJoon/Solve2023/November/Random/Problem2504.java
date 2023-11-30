package BaekJoon.Solve2023.November.Random;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Problem2504 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String src = br.readLine();
        Stack<Integer> stack = new Stack<>();
        int res = 0;
        int val = 1;
        for (int i = 0; i < src.length(); i++) {
            char c = src.charAt(i);

            if (c == '(') {
                stack.push(2);
                val *= 2;
            }
            if (c == '[') {
                stack.push(3);
                val *= 3;
            }
            if (c == ')') {
                if (stack.isEmpty() || stack.peek() != 2) {
                    res = 0;
                    break;
                } else if (src.charAt(i - 1) == '(') {
                    res += val;
                }
                stack.pop();
                val /= 2;
            }
            if (c == ']') {
                if (stack.isEmpty() || stack.peek() != 3) {
                    res = 0;
                    break;
                } else if (src.charAt(i - 1) == '[') {
                    res += val;
                }
                stack.pop();
                val /= 3;
            }
        }

        if (!stack.isEmpty()) System.out.print("0");
        else System.out.print(res);

        br.close();
    }
}
