package BaekJoon.Solve2025.September.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Problem5545 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int cal = Integer.parseInt(br.readLine());
        int price = a;
        PriorityQueue<Integer> pq = new PriorityQueue<>((i1, i2) -> i2 - i1);
        for (int i = 0; i < n; i++) {
            pq.offer(Integer.parseInt(br.readLine()));
        }

        while (!pq.isEmpty()) {
            double now = (double) cal / price;
            int next = pq.poll();
            double tmp = (double) (cal + next) / (price + b);
            if (now > tmp) break;

            cal += next;
            price += b;
        }

        System.out.print(cal / price);

        br.close();
    }
}
