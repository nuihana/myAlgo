package BaekJoon.Solve2025.November.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Problem11582 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int k = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n;) {
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            for (int j = 0; j < n / k; j++) {
                pq.add(arr[i++]);
            }

            while (!pq.isEmpty()) {
                sb.append(pq.poll()).append(" ");
            }
        }
        System.out.print(sb);

        br.close();
    }
}
