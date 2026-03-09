package BaekJoon.Solve2026.March.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem5426 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            String src = br.readLine();
            int len = (int) Math.sqrt(src.length());

            char[][] arr = new char[len][len];
            for (int i = 0; i < len; i++) {
                for (int j = 0; j < len; j++) {
                    arr[i][j] = src.charAt(i * len + j);
                }
            }

            for (int i = len - 1; i >= 0; i--) {
                for (int j = 0; j < len; j++) {
                    sb.append(arr[j][i]);
                }
            }
            sb.append("\n");
        }
        System.out.print(sb);

        br.close();
    }
}
