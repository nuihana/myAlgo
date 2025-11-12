package BaekJoon.Solve2025.November.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem3568 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String src = br.readLine();
        String[] split = src.split(" ");

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < split.length; i++) {
            StringBuilder isb = new StringBuilder();

            isb.append(split[0]);
            String now = split[i];
            for (int j = now.length() - 2; j >= 0; j--) {
                if ((now.charAt(j) >= 'a' && now.charAt(j) <= 'z')
                        || (now.charAt(j) >= 'A' && now.charAt(j) <= 'Z')) {
                    isb.append(" ").append(now.substring(0, j + 1)).append(";");
                    break;
                }

                if (now.charAt(j) == ']') {
                    isb.append("[]");
                    j--;
                } else {
                    isb.append(now.charAt(j));
                }
            }
            sb.append(isb).append("\n");
        }
        System.out.print(sb);

        br.close();
    }
}
