package BaekJoon.Solve2024.September.DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Problem11899 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String src = br.readLine();
        Stack<Character> stack = new Stack<>();
        int res = 0;
        for (int i = 0; i < src.length(); i++) {
            char c = src.charAt(i);
            if (stack.isEmpty()) {
                if (c == ')') {
                    res++;
                } else {
                    stack.push(c);
                }
            } else {
                if (c == ')') {
                    stack.pop();
                } else {
                    stack.push(c);
                }
            }
        }
        res += stack.size();
        System.out.print(res);

        br.close();
    }
}
