package BaekJoon.Solve2023.June.Greedy;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Problem1946 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int testCnt = Integer.parseInt(br.readLine());
        for (int testNum = 0; testNum < testCnt; testNum++) {
            int numCnt = Integer.parseInt(br.readLine());

            List<int[]> list = new ArrayList<>();
            for (int i = 0; i < numCnt; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                list.add(new int[]{a, b});
            }

            list.sort((a1, a2) -> a1[0] - a2[0]);
            PriorityQueue<int[]> que = new PriorityQueue<>((a1, a2) -> a1[1] - a2[1]);
            que.add(list.get(0));
            for (int i = 1; i < list.size(); i++) {
                int[] now = list.get(i);
                if (now[1] < que.peek()[1]) {
                    que.add(now);
                }
            }

            bw.write(String.valueOf(que.size()));
            bw.newLine();
        }

        br.close();
        bw.close();
    }
}
