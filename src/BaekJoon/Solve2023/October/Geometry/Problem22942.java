package BaekJoon.Solve2023.October.Geometry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Problem22942 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        PriorityQueue<int[]> que = new PriorityQueue<>((a1, a2) -> a1[1] - a2[1]);
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());

            que.offer(new int[]{ i, x - r });
            que.offer(new int[]{ i, x + r });
        }

        Stack<Integer> stack = new Stack<>();
        while (!que.isEmpty()) {
            int[] item = que.poll();
            if (stack.isEmpty()) stack.push(item[0]);
            else {
                if (stack.peek() == item[0]) stack.pop();
                else stack.push(item[0]);
            }
        }

        if (stack.isEmpty()) System.out.print("YES");
        else System.out.print("NO");

        br.close();
    }
}
