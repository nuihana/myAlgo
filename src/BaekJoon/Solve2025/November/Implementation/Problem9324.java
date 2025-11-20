package BaekJoon.Solve2025.November.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem9324 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (n-- > 0) {
            String src = br.readLine();

            if (isSMTP(src)) sb.append("OK").append("\n");
            else sb.append("FAKE").append("\n");
        }
        System.out.print(sb);

        br.close();
    }

    private boolean isSMTP(String src) {
        int[] cnt = new int[26];
        for (int i = 0; i < src.length(); i++) {
            cnt[src.charAt(i) - 'A']++;

            if (cnt[src.charAt(i) - 'A'] % 3 == 0) {
                if (i == src.length() - 1 || src.charAt(i + 1) != src.charAt(i++)) return false;
            }
        }
        return true;
    }
}
