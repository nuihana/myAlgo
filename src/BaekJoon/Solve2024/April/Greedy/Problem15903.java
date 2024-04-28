package BaekJoon.Solve2024.April.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Problem15903 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int numCnt = Integer.parseInt(st.nextToken());
        int sumCnt = Integer.parseInt(st.nextToken());

        PriorityQueue<Long> q = new PriorityQueue<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < numCnt; i++) {
            q.offer(Long.parseLong(st.nextToken()));
        }

        while (sumCnt-- > 0) {
            long top = q.poll();
            long second = q.poll();

            q.offer(top + second);
            q.offer(top + second);
        }

        long res = 0;
        while (!q.isEmpty()) {
            res += q.poll();
        }

        System.out.print(res);

        br.close();
    }
}
