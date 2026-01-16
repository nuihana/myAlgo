package BaekJoon.Solve2026.January.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem5789 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (n-- > 0) {
            String src = br.readLine();

            int half = src.length() / 2;
            if (src.charAt(half - 1) == src.charAt(half)) sb.append("Do-it").append("\n");
            else sb.append("Do-it-Not").append("\n");
        }
        System.out.print(sb);

        br.close();
    }
}
