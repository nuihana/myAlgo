package BaekJoon.Solve2023.June.Greedy;

import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Problem21599 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        PriorityQueue<Integer> que = new PriorityQueue<>((i1, i2) -> i2 - i1);
        while(st.hasMoreTokens()) {
            que.offer(Integer.parseInt(st.nextToken()));
        }

        int result = 0;
        int idx = 0;
        while(!que.isEmpty()) {
            int i = que.poll();
            if (i > 0) {
                result = Math.max(result, i + idx);
            }
            idx++;
            if (result >= n) {
                result = n;
                break;
            }
        }

        bw.write(String.valueOf(result));

        br.close();
        bw.close();
    }
}
