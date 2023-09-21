package BaekJoon.Solve2023.September.Greedy;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Problem1461 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        List<Integer> positive = new ArrayList<>();
        List<Integer> negative = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int d = Integer.parseInt(st.nextToken());

            if (d > 0) positive.add(d);
            else negative.add(d);
        }

        positive.sort((i1, i2) -> Math.abs(i1) - Math.abs(i2));
        negative.sort((i1, i2) -> Math.abs(i1) - Math.abs(i2));

        PriorityQueue<Integer> que = new PriorityQueue<>((i1, i2) -> Math.abs(i1) - Math.abs(i2));
        int idx = positive.size() % m == 0 ? m - 1 : positive.size() % m - 1;
        for (int i = idx; i < positive.size(); i += m) {
            que.offer(positive.get(i));
        }

        idx = negative.size() % m == 0 ? m - 1 : negative.size() % m - 1;
        for (int i = idx; i < negative.size(); i += m) {
            que.offer(negative.get(i));
        }

        int res = 0;
        while (!que.isEmpty()) {
            if (que.size() == 1) {
                res += Math.abs(que.poll());
                break;
            }
            int d = que.poll();
            res += Math.abs(d) * 2;
        }
        bw.write(String.valueOf(res));

        br.close();
        bw.close();
    }
}
