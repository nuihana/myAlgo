package BaekJoon.Solve2024.March.DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Problem2161 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= n; i++) q.offer(i);

        StringBuilder sb = new StringBuilder();
        while (!q.isEmpty()) {
            sb.append(q.poll()).append(" ");
            if (!q.isEmpty()) {
                q.offer(q.poll());
            }
        }

        System.out.print(sb);

        br.close();
    }
}
