package BaekJoon.Solve2024.February.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Problem5397 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (n-- > 0) {
            String str = br.readLine();

            Stack<Character> left = new Stack<>();
            Stack<Character> right = new Stack<>();

            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                if (c == '<') {
                    if (left.isEmpty()) continue;
                    right.push(left.pop());
                } else if (c == '>') {
                    if (right.isEmpty()) continue;
                    left.push(right.pop());
                } else if (c == '-') {
                    if (left.isEmpty()) continue;
                    left.pop();
                } else {
                    left.push(c);
                }
            }

            StringBuilder isb = new StringBuilder();
            while (!left.isEmpty()) isb.append(left.pop());
            isb.reverse();
            while (!right.isEmpty()) isb.append(right.pop());

            sb.append(isb).append("\n");
        }

        System.out.print(sb);

        br.close();
    }
}
