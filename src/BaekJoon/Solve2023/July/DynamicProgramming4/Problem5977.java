package BaekJoon.Solve2023.July.DynamicProgramming4;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Problem5977 {
    long[] totalSum;
    long[] dp;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int cowCnt = Integer.parseInt(st.nextToken());
        int serialLimit = Integer.parseInt(st.nextToken());

        int[] cowArr = new int[cowCnt];
        for (int i = 0; i < cowCnt; i++) {
            cowArr[i] = Integer.parseInt(br.readLine());
        }

        totalSum = new long[cowCnt];
        totalSum[0] = cowArr[0];
        for (int i = 1; i < cowCnt; i++) {
            totalSum[i] = totalSum[i - 1] + cowArr[i];
        }

        dp = new long[cowCnt];
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < cowCnt; i++) {
            while (!deque.isEmpty() && deque.peekFirst() < i - serialLimit) deque.pollFirst();
            while (!deque.isEmpty() && calc(deque.peekLast()) <= calc(i)) deque.pollLast();
            deque.offerLast(i);
            dp[i] = totalSum[i] + calc(deque.peekFirst());
            if (i <= serialLimit) dp[i] = Math.max(dp[i], totalSum[i]);
        }

        br.close();
        bw.close();
    }

    private long calc(int i) {
        return dp[i - 1] - totalSum[i];
    }
}
