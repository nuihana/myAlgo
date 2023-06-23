package BaekJoon.Solve2023.June.Greedy;

import java.io.*;
import java.util.*;

public class Problem11000 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int cnt = Integer.parseInt(br.readLine());
        int[][] clas = new int[cnt][2];
        for (int i = 0; i < cnt; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            clas[i][0] = Integer.parseInt(st.nextToken());
            clas[i][1] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(clas, (a1, a2) -> a1[0] - a2[0]);

        PriorityQueue<Integer> que = new PriorityQueue<>();
        for (int[] tmp : clas) {
            if (que.isEmpty()) {
                que.offer(tmp[1]);
                continue;
            }

            if (que.peek() <= tmp[0]) {
                que.poll();
                que.offer(tmp[1]);
            } else {
                que.offer(tmp[1]);
            }
        }

        bw.write(String.valueOf(que.size()));

        br.close();
        bw.close();
    }
}
