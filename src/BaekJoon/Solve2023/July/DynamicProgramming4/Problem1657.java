package BaekJoon.Solve2023.July.DynamicProgramming4;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem1657 {
    int height;
    int width;
    String str;
    int[][] dp;
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        height = Integer.parseInt(st.nextToken());
        width = Integer.parseInt(st.nextToken());
        str = "";

        for (int i = 0; i < height; i++) {
            String line = br.readLine();
            str = str.concat(line);
        }

        dp = new int[height * width][(1 << width)];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }

        bw.write(String.valueOf(memoization(0, 0)));

        br.close();
        bw.close();
    }

    private int memoization(int idx, int bit) {
        if (idx >= height * width) {
            if (idx == height * width && bit == 0) {
                return 0;
            } else {
                return -2000;
            }
        }

        if (dp[idx][bit] != -1) return dp[idx][bit];
        int res = memoization(idx + 1, bit >> 1); // 현재 칸을 포함하지 않은 case 조회
        if ((bit & 1) == 0) { // 현재칸이 비었을때만 채워넣는 경우의 수 조회
            if (idx % width < width - 1 && (bit & (1 << 1)) == 0) {
                res = Math.max(res, getValue(str.charAt(idx), str.charAt(idx + 1))
                        + memoization(idx + 2, bit >> 2));
            }
            if (idx / width < height - 1) {
                res = Math.max(res, getValue(str.charAt(idx), str.charAt(idx + width))
                        + memoization(idx + 1, (bit >> 1) | (1 << (width - 1))));
            }
        }

        return dp[idx][bit] = res;
    }

    int[][] value = {{10, 8, 7, 5, 1}, {8, 6, 4, 3, 1}, {7, 4, 3, 2, 1}, {5, 3, 2, 2, 1}, {1, 1, 1, 1, 0}};
    private int getValue(char c1, char c2) {
        int i = c1 == 'A' ? 0 : c1 == 'B' ? 1 : c1 == 'C' ? 2 : c1 == 'D' ? 3 : 4;
        int j = c2 == 'A' ? 0 : c2 == 'B' ? 1 : c2 == 'C' ? 2 : c2 == 'D' ? 3 : 4;

        return value[i][j];
    }
}
