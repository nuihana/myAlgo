package BaekJoon.Solve2023.May.Random;

import java.io.*;
import java.util.*;

public class Problem12851 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        if (start >= end) {
            bw.write(String.valueOf(start - end));
            bw.newLine();
            bw.write("1");
            bw.close();
            return;
        }

        final int MAXIMUM = 100000;
        int[] visited = new int[MAXIMUM + 1];
        Queue<Integer> que = new LinkedList<>();

        que.offer(start);
        visited[start] = 1;

        int time = Integer.MAX_VALUE;
        int count = 0;
        while(!que.isEmpty()) {
            int now = que.poll();

            if (time < visited[now]) continue;

            for (int i = 0; i < 3; i++) {
                int next;

                if (i == 0) {
                    next = now + 1;
                } else if (i == 1) {
                    next = now - 1;
                } else {
                    next = now * 2;
                }

                if (next < 0 || next > MAXIMUM) continue;

                if (next == end) {
                    time = visited[now];
                    count++;
                }

                if (visited[next] == 0 || visited[next] == visited[now] + 1) {
                    que.add(next);
                    visited[next] = visited[now] + 1;
                }
            }
        }

        bw.write(String.valueOf(time));
        bw.newLine();
        bw.write(String.valueOf(count));

        br.close();
        bw.close();
    }
}
