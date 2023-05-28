package BaekJoon.Solve2023.May.DynamicProgramming3;

import java.io.*;

public class Problem2482 {
    int colorCnt;
    Long[][] dp;
    final int mod = 1000000003;
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        colorCnt = Integer.parseInt(br.readLine());
        int pickCnt = Integer.parseInt(br.readLine());
        dp = new Long[colorCnt + 1][pickCnt + 1];

        bw.write(String.valueOf((memoization(colorCnt - 1, pickCnt) + memoization(colorCnt - 3, pickCnt - 1)) % mod));

        br.close();
        bw.close();
    }

    private long memoization(int idx, int cnt) { // dp[n][i] = n개 중에 i개의 색을 고를 수 있는 가짓수
        if (idx < 0) return 0;
        if (cnt == 0) return dp[idx][cnt] = 1L;
        if (cnt == 1) return dp[idx][cnt] = (long) idx;
        if (dp[idx][cnt] != null) return dp[idx][cnt];

        dp[idx][cnt] = 0L;
        dp[idx][cnt] += memoization(idx - 2, cnt - 1) % mod;
        dp[idx][cnt] += memoization(idx - 1, cnt) % mod;

        return dp[idx][cnt];
    }
}
