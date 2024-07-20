package BaekJoon.Solve2024.July.BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Problem2635 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int resCnt = 0;
        List<Integer> resList = new ArrayList<>();
        for (int m = 1; m <= n; m++) {
            int bf = n;

            Queue<Integer> q = new LinkedList<>();
            q.offer(n);
            int now = m;
            q.offer(now);
            while (bf - now >= 0) {
                now = bf - now;
                bf -= now;
                q.offer(now);
            }

            if (q.size() > resCnt) {
                resCnt = q.size();

                resList.clear();
                while (!q.isEmpty()) resList.add(q.poll());
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(resCnt).append("\n");
        for (int i = 0; i < resList.size(); i++) {
            sb.append(resList.get(i)).append(" ");
        }

        System.out.print(sb);

        br.close();
    }
}
