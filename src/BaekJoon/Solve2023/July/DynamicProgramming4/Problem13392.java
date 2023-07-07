package BaekJoon.Solve2023.July.DynamicProgramming4;

import java.io.*;

public class Problem13392 {
    String start, end;
    Integer[][] dp;
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int cnt = Integer.parseInt(br.readLine());
        start = br.readLine();
        end = br.readLine();

        dp = new Integer[cnt][11]; // i번째 숫자나사가 위에서 왼쪽으로 j번 회전했을 때 목표 숫자에 도달하기위한 회전칸수

        bw.write(String.valueOf(memoization(0, 0)));

        br.close();
        bw.close();
    }

    private int memoization(int n, int m) {
        if (n == dp.length) return 0;
        if (dp[n][m] != null) return dp[n][m];

        int from = start.charAt(n) - 48 + m; // m번 왼쪽으로 회전한 상태
        from %= 10;
        int to = end.charAt(n) - 48;

        if (from == to) return dp[n][m] = memoization(n + 1, m);

        int left = to > from ? to - from : 10 - from + to;
        int right = 10 - left;

        return dp[n][m] = Math.min(left + memoization(n + 1, (m + left) % 10), right + memoization(n + 1, m));
    }
}
