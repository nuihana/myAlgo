package BaekJoon.Solve2024.September.DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Problem18115 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] query = new int[n];
        for (int i = 0; i < n; i++) {
            query[i] = Integer.parseInt(st.nextToken());
        }

        Deque<Integer> dq = new LinkedList<>();
        for (int i = n - 1, num = 1; i >= 0; i--) {
            if (query[i] == 1) {
                dq.addLast(num++);
            } else if (query[i] == 2) {
                int tmp = dq.getLast();
                dq.removeLast();
                dq.addLast(num++);
                dq.addLast(tmp);
            } else if (query[i] == 3) {
                dq.addFirst(num++);
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!dq.isEmpty()) {
            sb.append(dq.pollLast()).append(" ");
        }
        System.out.print(sb);

        br.close();
    }
}
