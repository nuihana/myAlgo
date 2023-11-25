package BaekJoon.Solve2023.November.Random;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Problem2493 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        List<int[]> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            int num = Integer.parseInt(st.nextToken());
            list.add(new int[]{ i, num });
        }

        Stack<int[]> stack = new Stack<>();
        for (int[] now : list) {
            while (!stack.isEmpty() && stack.peek()[1] <= now[1]) stack.pop();

            if (stack.isEmpty()) {
                System.out.print("0 ");
            } else {
                System.out.print(stack.peek()[0] + " ");
            }
            stack.push(now);
        }

        br.close();
    }
}
