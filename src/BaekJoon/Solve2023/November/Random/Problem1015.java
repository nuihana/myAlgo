package BaekJoon.Solve2023.November.Random;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Problem1015 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        PriorityQueue<int[]> que = new PriorityQueue<>((a1, a2) -> a1[1] != a2[1] ? a1[1] - a2[1] : a1[0] - a2[0]);
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int val = Integer.parseInt(st.nextToken());
            que.offer(new int[]{ i, val });
        }

        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            int[] now = que.poll();
            res[now[0]] = i;
        }

        for (int num : res) {
            System.out.print(num + " ");
        }

        br.close();
    }
}
