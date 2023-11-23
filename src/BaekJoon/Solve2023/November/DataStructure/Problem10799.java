package BaekJoon.Solve2023.November.DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Problem10799 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String src = br.readLine();

        int res = 0;
        Stack<Integer> stack = new Stack<>();
        boolean flag = false;
        for (int i = 0; i < src.length(); i++) {
            char c = src.charAt(i);
            if (c == '(') {
                stack.push(1);
                flag = true;
            }
            if (c == ')') {
                stack.pop();
                if (flag) res += stack.size();
                else res++;
                flag = false;
            }
        }

        System.out.print(res);

        br.close();
    }
}
