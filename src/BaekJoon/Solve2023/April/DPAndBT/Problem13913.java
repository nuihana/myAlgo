package BaekJoon.Solve2023.April.DPAndBT;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Problem13913 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int from = Integer.parseInt(st.nextToken());
        int to = Integer.parseInt(st.nextToken());

        Integer[] dp = new Integer[100001];
        Queue<Integer> que = new LinkedList<>();
        que.offer(from);
        dp[from] = 0;

        while(!que.isEmpty()) {
            int tmp = que.poll();

            if (tmp * 2 <= 100000 && dp[tmp * 2] == null) {
                dp[tmp * 2] = dp[tmp] + 1;
                que.offer(tmp * 2);
            }

            if (tmp > 0 && dp[tmp - 1] == null) {
                dp[tmp - 1] = dp[tmp] + 1;
                que.offer(tmp - 1);
            }

            if (tmp < 100000 && dp[tmp + 1] == null) {
                dp[tmp + 1] = dp[tmp] + 1;
                que.offer(tmp + 1);
            }

            if (dp[to] != null) {
                que.clear();
            }
        }

        bw.write(String.valueOf(dp[to]));
        bw.newLine();

        int ord = dp[to];
        int idx = to;
        Stack<Integer> stack = new Stack<>();
        stack.push(to);
        while(ord > 0) {
            ord--;

            if (idx % 2 == 0 && idx / 2 > 0 && dp[idx / 2] != null && dp[idx / 2] == ord) {
                stack.push(idx / 2);
                idx /= 2;
                continue;
            }

            if (idx > 0 && dp[idx - 1] != null && dp[idx - 1] == ord) {
                stack.push(idx - 1);
                idx -= 1;
                continue;
            }

            if (idx < 100000 && dp[idx + 1] != null && dp[idx + 1] == ord) {
                stack.push(idx + 1);
                idx += 1;
            }
        }

        while (!stack.empty()) {
            bw.write(stack.pop() + " ");
        }

        br.close();
        bw.close();
    }
}
