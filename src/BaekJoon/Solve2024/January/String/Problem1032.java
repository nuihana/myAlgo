package BaekJoon.Solve2024.January.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem1032 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        char[] init = null;
        boolean[] same = null;
        for (int i = 0; i < n; i++) {
            String src = br.readLine();

            if (i == 0) {
                init = new char[src.length()];
                same = new boolean[src.length()];
                for (int j = 0; j < src.length(); j++) {
                    init[j] = src.charAt(j);
                }
            } else {
                for (int j = 0; j < src.length(); j++) {
                    if (!same[j] && init[j] != src.charAt(j)) same[j] = true;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < same.length; i++) {
            if (same[i]) sb.append("?");
            else sb.append(init[i]);
        }

        System.out.print(sb);

        br.close();
    }
}
