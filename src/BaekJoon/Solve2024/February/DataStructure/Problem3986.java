package BaekJoon.Solve2024.February.DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Problem3986 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int res = 0;
        while (n-- > 0) {
            String src = br.readLine();
            Stack<Character> stack = new Stack<>();

            for (int i = 0; i < src.length(); i++) {
                char c = src.charAt(i);
                if (stack.isEmpty()) {
                    stack.push(c);
                } else {
                    if (stack.peek() == c) {
                        stack.pop();
                    } else {
                        stack.push(c);
                    }
                }
            }

            if (stack.isEmpty()) {
                res++;
            }
        }
        System.out.print(res);

        br.close();
    }
}
