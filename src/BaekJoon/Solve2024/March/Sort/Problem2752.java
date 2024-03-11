package BaekJoon.Solve2024.March.Sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem2752 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        Queue<Integer> q = new PriorityQueue<>();
        for (int i = 0; i < 3; i++) {
            q.offer(Integer.parseInt(st.nextToken()));
        }

        while (!q.isEmpty()) {
            System.out.print(q.poll() + " ");
        }

        br.close();
    }
}
