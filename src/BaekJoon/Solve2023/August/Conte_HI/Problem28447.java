package BaekJoon.Solve2023.August.Conte_HI;

import java.io.*;
import java.util.StringTokenizer;

public class Problem28447 {
    int[][] taste;
    int[] seq;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        taste = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                taste[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        seq = new int[k];

        bw.write(String.valueOf(dfs(k, 0, 0)));

        br.close();
        bw.close();
    }

    private int dfs(int k, int si, int idx) {
        if (k == si) {
            return calc();
        }

        int res = Integer.MIN_VALUE;
        for (int i = idx; i < taste.length; i++) {
            seq[si] = i;
            res = Math.max(res, dfs(k, si + 1, i + 1));
        }

        return res;
    }

    private int calc() {
        int res = 0;
        for (int i = 0; i < seq.length; i++) {
            for (int j = i + 1; j < seq.length; j++) {
                res += taste[seq[i]][seq[j]];
            }
        }
        return res;
    }
}
