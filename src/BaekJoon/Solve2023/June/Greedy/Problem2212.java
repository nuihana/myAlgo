package BaekJoon.Solve2023.June.Greedy;

import java.io.*;
import java.util.*;

public class Problem2212 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int sensorCnt = Integer.parseInt(br.readLine());
        int centerCnt = Integer.parseInt(br.readLine());

        int[] sensor = new int[sensorCnt];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < sensorCnt; i++) {
            sensor[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(sensor);

        PriorityQueue<Integer> que = new PriorityQueue<>((i1, i2) -> i2 - i1);
        for (int i = 1; i < sensorCnt; i++) {
            que.offer(sensor[i] - sensor[i - 1]);
        }

        int rm = centerCnt - 1;
        int result = 0;
        while(!que.isEmpty()) {
            int term = que.poll();
            if (rm > 0) {
                rm--;
                continue;
            }

            result += term;
        }

        bw.write(String.valueOf(result));

        br.close();
        bw.close();
    }
}
