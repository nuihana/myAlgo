package BaekJoon.Solve2024.September.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Problem13417 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (tc-- > 0) {
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());

            Deque<String> dq = new ArrayDeque<>();
            dq.addFirst(st.nextToken());
            for (int i = 1; i < n; i++) {
                String top = dq.peekFirst();
                String input = st.nextToken();

                if (top.compareTo(input) >= 0) {
                    dq.addFirst(input);
                } else {
                    dq.addLast(input);
                }
            }

            StringBuilder isb = new StringBuilder();
            while (!dq.isEmpty()) {
                isb.append(dq.pollFirst());
            }

            sb.append(isb).append("\n");
        }
        System.out.print(sb);

        br.close();
    }
}
