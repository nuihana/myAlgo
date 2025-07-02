package BaekJoon.Solve2025.July.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Problem9933 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        Set<String> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(br.readLine());
        }

        for (String src : set) {
            StringBuilder sb = new StringBuilder();
            for (int i = src.length() - 1; i >= 0; i--) {
                sb.append(src.charAt(i));
            }
            if (set.contains(sb.toString())) {
                System.out.print(src.length() + " " + src.charAt(src.length() / 2));
                break;
            }
        }

        br.close();
    }
}
