package BaekJoon.Solve2024.August.DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Problem4889 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        int seq = 1;
        while (true) {
            String input = br.readLine();
            if (input.charAt(0) == '-') break;

            Stack<Character> stack = new Stack<>();
            for (int i = 0; i < input.length(); i++) {
                char now = input.charAt(i);

                if (stack.isEmpty()) {
                    stack.push(now);
                } else {
                    char top = stack.peek();
                    if (top == '{' && now == '}') stack.pop();
                    else stack.push(now);
                }
            }

            int res = 0;
            boolean flag = true;
            while (!stack.isEmpty()) {
                char top = stack.pop();
                if (flag && top == '{') {
                    res++;
                } else if (!flag && top == '}'){
                    res++;
                }
                flag = !flag;
            }

            sb.append(seq).append(". ").append(res).append("\n");
        }
        System.out.print(sb);

        br.close();
    }
}
