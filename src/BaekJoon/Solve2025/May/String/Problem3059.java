package BaekJoon.Solve2025.May.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Problem3059 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            String src = br.readLine();

            Set<Character> set = new HashSet<>();
            for (int i = 0; i < src.length(); i++) {
                char c = src.charAt(i);
                set.add(c);
            }

            int res = 0;
            for (int i = 0; i < 26; i++) {
                char c = (char) (i + 65);
                if (!set.contains(c)) res += i + 65;
            }

            sb.append(res).append("\n");
        }
        System.out.print(sb);

        br.close();
    }
}
