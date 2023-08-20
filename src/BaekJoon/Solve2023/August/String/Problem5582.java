package BaekJoon.Solve2023.August.String;

import java.io.*;

public class Problem5582 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String origin = br.readLine();
        String source = br.readLine();

        int[][] lcs = new int[origin.length() + 1][source.length() + 1];
        int res = 0;
        for (int i = 0; i < origin.length(); i++) {
            for (int j = 0; j < source.length(); j++) {
                if (i == 0 || j == 0) {
                    lcs[i][j] = 0;
                } else if (origin.charAt(i) == source.charAt(j)) {
                    lcs[i][j] = lcs[i - 1][j - 1] + 1;
                    res = Math.max(res, lcs[i][j]);
                } else {
                    lcs[i][j] = 0;
                }
            }
        }

        bw.write(String.valueOf(res));

        br.close();
        bw.close();
    }
}
