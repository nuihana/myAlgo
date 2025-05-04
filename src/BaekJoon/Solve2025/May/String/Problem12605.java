package BaekJoon.Solve2025.May.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Problem12605 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            Stack<String> stack = new Stack<>();
            while (st.hasMoreTokens()) {
                stack.push(st.nextToken());
            }

            sb.append("Case #").append(i).append(": ");
            while (!stack.isEmpty()) {
                sb.append(stack.pop()).append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb);

        br.close();
    }
}
