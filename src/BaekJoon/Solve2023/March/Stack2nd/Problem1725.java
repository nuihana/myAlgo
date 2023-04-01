package BaekJoon.Solve2023.March.Stack2nd;

import java.io.*;
import java.util.*;

public class Problem1725 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int histogramSize = Integer.parseInt(br.readLine());
        int[] histogram = new int[histogramSize + 2];

        for (int i = 1; i < histogramSize + 1; i++) {
            histogram[i] = Integer.parseInt(br.readLine());
        }

        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        int result = 0;
        for (int i = 1; i < histogramSize + 2; i++) {
            while (!stack.isEmpty()) {
                int top = stack.peek();
                if (histogram[top] <= histogram[i]) break;
                stack.pop();
                result = Math.max(result, histogram[top] * (i - stack.peek() - 1));
            }
            stack.push(i);
        }

        bw.write(String.valueOf(result));

        br.close();
        bw.close();
    }
}
