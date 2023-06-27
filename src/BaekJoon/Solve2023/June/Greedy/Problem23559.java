package BaekJoon.Solve2023.June.Greedy;

import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Problem23559 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int cnt = Integer.parseInt(st.nextToken());
        int wallet = Integer.parseInt(st.nextToken());

        PriorityQueue<int[]> que = new PriorityQueue<>((a1, a2) -> Math.abs(a2[0] - a2[1]) - Math.abs(a1[0] - a1[1]));
        for (int i = 0; i < cnt; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            que.offer(new int[]{a, b});
        }

        int maxA = wallet / 5000;
        while ((wallet - maxA * 5000) / 1000 < cnt - maxA) {
            maxA--;
        }

        long result = 0;
        while(!que.isEmpty()) {
            int[] menu = que.poll();
            if (menu[0] > menu[1] && maxA > 0) {
                result += menu[0];
                maxA--;
            } else {
                result += menu[1];
            }
        }

        bw.write(String.valueOf(result));

        br.close();
        bw.close();
    }
}
