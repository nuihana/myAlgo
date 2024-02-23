package BaekJoon.Solve2024.February.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Problem1935 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String src = br.readLine();
        int[] values = new int[n];
        for (int i = 0; i < n; i++) {
            values[i] = Integer.parseInt(br.readLine());
        }

        Stack<Double> stack = new Stack<>();
        for (int i = 0; i < src.length(); i++) {
            char c = src.charAt(i);
            if (c >= 'A' && c <= 'Z') {
                stack.push(0D + values[c - 'A']);
            } else {
                double b = stack.pop();
                double a = stack.pop();

                if (c == '+') {
                    stack.push(a + b);
                } else  if (c == '-') {
                    stack.push(a - b);
                } else  if (c == '*') {
                    stack.push(a * b);
                } else {
                    stack.push(a / b);
                }
            }
        }
        System.out.print(String.format("%.2f", stack.pop()));

        br.close();
    }
}
