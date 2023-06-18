package BaekJoon.Solve2023.June.Random;

import java.io.*;
import java.util.PriorityQueue;
import java.util.Queue;

public class Problem18110 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int cnt = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> que = new PriorityQueue<>((i1, i2) -> i1 - i2);
        for (int i = 0; i < cnt; i++) {
            int num = Integer.parseInt(br.readLine());
            que.offer(num);
        }

        if (cnt == 0) {
            bw.write("0");
        } else {
            int cut = (int) Math.round((double) cnt * 0.15);
            for (int i = 0; i < cut; i++) {
                que.poll();
            }

            int sum = 0;
            int sumcnt = 0;
            while(que.size() > cut) {
                sum += que.poll();
                sumcnt++;
            }

            bw.write(String.valueOf((int) Math.round((double) sum / sumcnt)));
        }

        br.close();
        bw.close();
    }
}
