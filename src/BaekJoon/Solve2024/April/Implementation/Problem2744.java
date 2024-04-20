package BaekJoon.Solve2024.April.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem2744 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String src = br.readLine();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < src.length(); i++) {
            char c = src.charAt(i);

            if (c > 'Z') {
                sb.append(c - ('a' - 'A'));
            } else {
                sb.append(c + ('a' - 'A'));
            }
        }

        System.out.print(sb);

        br.close();
    }
}
