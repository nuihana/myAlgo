package BaekJoon.Solve2024.June.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem9996 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int fileCnt = Integer.parseInt(br.readLine());
        String[] pattern = br.readLine().split("[*]");
        int patternLength = pattern[0].length() + pattern[1].length();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < fileCnt; i++) {
            String src = br.readLine();

            boolean isPass = src.length() >= patternLength;
            for (int j = 0; j < pattern[0].length(); j++) {
                if (isPass && src.charAt(j) != pattern[0].charAt(j)) {
                    isPass = false;
                    break;
                }
            }

            for (int j = 0; j < pattern[1].length(); j++) {
                if (isPass && src.charAt(src.length() - (j + 1)) != pattern[1].charAt(pattern[1].length() - (j + 1))) {
                    isPass = false;
                    break;
                }
            }

            if (isPass) {
                sb.append("DA");
            } else {
                sb.append("NE");
            }
            sb.append("\n");
        }

        System.out.print(sb);

        br.close();
    }
}
