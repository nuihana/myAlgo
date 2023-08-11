package BaekJoon.Solve2023.August.Random;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem1158 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        Queue<Integer> que = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            que.offer(i);
        }

        StringBuilder sb = new StringBuilder();
        sb.append("<");
        int idx = 0;
        while(!que.isEmpty()) {
            int now = que.poll();
            idx++;

            if (idx == k) {
                sb.append(now);
                if (!que.isEmpty()) {
                    sb.append(", ");
                }
                idx = 0;
            } else {
                que.offer(now);
            }
        }
        sb.append(">");

        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}
