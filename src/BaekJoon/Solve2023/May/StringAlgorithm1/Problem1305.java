package BaekJoon.Solve2023.May.StringAlgorithm1;

import java.io.*;

public class Problem1305 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int maxLen = Integer.parseInt(br.readLine());
        String src = br.readLine();

        int[] table = new int[maxLen];

        int idx = 0;
        for (int i = 1; i < maxLen; i++) {
            if(idx > 0 && src.charAt(i) != src.charAt(idx)) {
                idx = table[idx - 1];
            }

            if (src.charAt(i) == src.charAt(idx)) {
                idx++;
                table[i] = idx;
            }
        }

        bw.write(String.valueOf(maxLen - table[maxLen - 1]));

        br.close();
        bw.close();
    }
}
