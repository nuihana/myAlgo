package BaekJoon.Solve2024.September.DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Problem14235 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        PriorityQueue<Integer> pq = new PriorityQueue<>((i1, i2) -> i2 - i1);
        while (n-- > 0) {
            String src = br.readLine();
            if ("0".equals(src)) {
                if (pq.isEmpty()) {
                    sb.append("-1");
                } else {
                    sb.append(pq.poll());
                }
                sb.append("\n");
            } else {
                StringTokenizer st = new StringTokenizer(src);

                int cnt = Integer.parseInt(st.nextToken());
                while (cnt-- > 0) {
                    pq.offer(Integer.parseInt(st.nextToken()));
                }
            }
        }

        System.out.print(sb);

        br.close();
    }
}
