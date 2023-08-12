package BaekJoon.Solve2023.August.Random;

import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Problem16435 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());

        PriorityQueue<Integer> que = new PriorityQueue<>((i1, i2) -> i1 - i2);
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int hi = Integer.parseInt(st.nextToken());
            que.offer(hi);
        }

        while (!que.isEmpty() && que.peek() <= l) {
            que.poll();
            l++;
        }

        bw.write(String.valueOf(l));

        br.close();
        bw.close();
    }
}
