package BaekJoon.Solve2026.Feburary.DivideAndConquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem1802 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            String src = br.readLine();

            if (isPossible(src)) sb.append("YES").append("\n");
            else sb.append("NO").append("\n");
        }
        System.out.print(sb);

        br.close();
    }

    private boolean isPossible(String src) {
        if (src.length() < 2) return true;

        int mid = src.length() / 2;
        for (int i = 1; mid + i < src.length(); i++) {
            if (src.charAt(mid + i) == src.charAt(mid - i)) return false;
        }

        boolean chk = isPossible(src.substring(0, mid));
        chk &= isPossible(src.substring(mid));

        return chk;
    }
}
