package BaekJoon.Solve2025.October.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Problem19638 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());

        PriorityQueue<Integer> pq = new PriorityQueue<>((i1, i2) -> i2 - i1);
        for (int i = 0; i < n; i++) {
            pq.offer(Integer.parseInt(br.readLine()));
        }

        int cnt = 0;
        while (t-- > 0) {
            if (pq.peek() < h) break;
            pq.offer(pq.peek() == 1 ? pq.poll() : pq.poll() / 2);
            cnt++;
        }

        int max = pq.poll();
        if (max < h) {
            System.out.println("YES");
            System.out.print(cnt);
        } else {
            System.out.println("NO");
            System.out.print(max);
        }

        br.close();
    }
}
