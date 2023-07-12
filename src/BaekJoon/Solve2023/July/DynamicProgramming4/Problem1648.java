package BaekJoon.Solve2023.July.DynamicProgramming4;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem1648 {
    int height;
    int width;
    int[][] dp;
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        height = Integer.parseInt(st.nextToken());
        width = Integer.parseInt(st.nextToken());

        dp = new int[height * width][(1 << width)];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }

        bw.write(String.valueOf(memoization(0, 0)));;

        br.close();
        bw.close();
    }

    private int memoization(int idx, int status) {
        if (idx >= height * width) {
            if (idx == height * width && status == 0)
                return 1;
            return 0;
        }

        int tmp = dp[idx][status];
        if (tmp != -1) return tmp;
        tmp = 0;

        if ((status & 1) > 0) tmp += memoization(idx + 1, status >> 1); // idx 이미 채워진 경우
        else {
            if (idx % width < width - 1 && (status & (1 << 1)) == 0) { // 맨 마지막줄 아니고, idx + 1번째 칸이 비어 있는 경우
                tmp += memoization(idx + 2, status >> 2);
            }
            tmp += memoization(idx + 1, (status >> 1) | (1 << (width - 1)));
        }
        tmp %= 9901;
        return dp[idx][status] = tmp;
    }
}
