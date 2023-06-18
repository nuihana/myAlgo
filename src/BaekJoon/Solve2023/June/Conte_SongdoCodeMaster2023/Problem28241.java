package BaekJoon.Solve2023.June.Conte_SongdoCodeMaster2023;

import java.io.*;
import java.util.*;

public class Problem28241 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int height = Integer.parseInt(st.nextToken());
        int width = Integer.parseInt(st.nextToken());

        int[][] field = new int[height + 1][];
        int[] cnt = new int[height + 1];
        int[] term = new int[height + 1];
        for (int i = 1; i <= height; i++) {
            st = new StringTokenizer(br.readLine());

            cnt[i] = Integer.parseInt(st.nextToken());
            field[i] = new int[cnt[i] + 2];
            for (int j = 1; j <= cnt[i]; j++) {
                field[i][j] = Integer.parseInt(st.nextToken());
            }
            field[i][cnt[i] + 1] = width + 1;

            term[i] = Integer.MAX_VALUE;
            for (int j = 0; j < cnt[i] + 1; j++) {
                term[i] = Math.min(term[i], field[i][j] - field[i][j + 1]);
            }
        }

        long[][] dp = new long[height][4];

        dp[0][2] = dp[0][3] = 1000000000000000000L;
        for (int i = 1; i <= height - 1; i++) {
            dp[i][0] = 2 + Math.min(dp[i - 1][0] + 2L * field[i][cnt[i]],
                    Math.min(dp[i - 1][1] + width + 1,
                            Math.min(dp[i - 1][2] + width + 1, dp[i - 1][3] + 2L * width + 2)));
            dp[i][1] = 2 + Math.min(dp[i - 1][0] + width + 1,
                    Math.min(dp[i - 1][1] + 2L * (width + 1 + term[i]),
                            Math.min(dp[i - 1][2] + 2L * width + 2, dp[i - 1][3] + width + 1)));
            dp[i][2] = 2 + Math.min(dp[i - 1][0] + width + 1,
                    Math.min(dp[i - 1][1] + 2L * width + 2,
                            Math.min(dp[i - 1][2] + 2L * (width + 1 + term[i]), dp[i - 1][3] + width + 1)));
            dp[i][3] = 2 + Math.min(dp[i - 1][0] + 2L * width + 2,
                    Math.min(dp[i - 1][1] + width + 1,
                            Math.min(dp[i - 1][2] + width + 1, dp[i - 1][3] + 2L * (width + 1 - field[i][1]))));
        }

        long result = Math.min(dp[height - 1][0] + 2L * width, Math.min(dp[height - 1][1] + width + 1,
                Math.min(dp[height - 1][2] + width + 1, dp[height - 1][3] + 2L * width)));
        bw.write(String.valueOf(result));

        br.close();
        bw.close();
    }
}
