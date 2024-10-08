package BaekJoon.Solve2024.October.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem15565 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        final int MAX = 1000001;
        int res = MAX;
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            int doll = Integer.parseInt(st.nextToken());
            if (doll == 1) {
                q.offer(i);
            }

            if (q.size() == k) {
                res = Math.min(res, i - q.poll() + 1);
            }
        }

        if (res == MAX) {
            System.out.print("-1");
        } else {
            System.out.print(res);
        }

        br.close();
    }
}
