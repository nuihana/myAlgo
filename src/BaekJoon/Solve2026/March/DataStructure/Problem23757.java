package BaekJoon.Solve2026.March.DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Problem23757 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        PriorityQueue<Integer> pq = new PriorityQueue<>((i1, i2) -> i2 - i1);
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            pq.offer(Integer.parseInt(st.nextToken()));
        }

        boolean isPossible = true;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            int now = Integer.parseInt(st.nextToken());
            int tmp = pq.poll();
            if (tmp < now) {
                isPossible = false;
                break;
            }
            pq.offer(tmp - now);
        }

        if (isPossible) System.out.print(1);
        else System.out.print(0);

        br.close();
    }
}
