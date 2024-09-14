package BaekJoon.Solve2024.September.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem2902 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String src = br.readLine();
        System.out.print(getShort(src));

        br.close();
    }

    private String getShort(String src) {
        StringBuilder sb = new StringBuilder();
        sb.append(src.charAt(0));
        for (int i = 1; i < src.length(); i++) {
            char c = src.charAt(i);
            if (c == '-') {
                sb.append(src.charAt(i + 1));
            }
        }

        return sb.toString();
    }
}
