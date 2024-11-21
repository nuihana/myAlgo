package BaekJoon.Solve2024.November.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem10820 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        while (true) {
            String src = br.readLine();

            if (src == null || src.isEmpty() || src.isBlank()) break;
            sb.append(getCharCnt(src)).append("\n");
        }
        System.out.print(sb);

        br.close();
    }

    private String getCharCnt(String src) {
        int upper = 0;
        int lower = 0;
        int num = 0;
        int blank = 0;

        for (int i = 0; i < src.length(); i++) {
            char c = src.charAt(i);
            if (c == ' ') {
                blank++;
            } else if (c >= 'a' && c <= 'z') {
                lower++;
            } else if (c >= 'A' && c <= 'Z') {
                upper++;
            } else {
                num++;
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(lower).append(" ")
                .append(upper).append(" ")
                .append(num).append(" ")
                .append(blank);
        return sb.toString();
    }
}
