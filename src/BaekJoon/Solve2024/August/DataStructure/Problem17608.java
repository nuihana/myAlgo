package BaekJoon.Solve2024.August.DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Problem17608 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        stack.push(Integer.parseInt(br.readLine()));
        n--;
        while (n-- > 0) {
            int num = Integer.parseInt(br.readLine());

            if (stack.peek() < num) {
                while (!stack.isEmpty() && stack.peek() <= num) {
                    stack.pop();
                }
            } else if (stack.peek() == num) {
                continue;
            }

            stack.push(num);
        }

        System.out.print(stack.size());

        br.close();
    }
}
