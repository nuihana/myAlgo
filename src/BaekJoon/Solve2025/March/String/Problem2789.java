package BaekJoon.Solve2025.March.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Problem2789 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String src = br.readLine();
        String ban = "CAMBRIDGE";
        Set<Character> set = new HashSet<Character>();
        for (int i = 0; i < ban.length(); i++) {
            set.add(ban.charAt(i));
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < src.length(); i++) {
            char c = src.charAt(i);
            if (!set.contains(c)) {
                sb.append(c);
            }
        }
        System.out.print(sb);

        br.close();
    }
}
