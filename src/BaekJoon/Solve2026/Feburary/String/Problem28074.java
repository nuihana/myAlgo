package BaekJoon.Solve2026.Feburary.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Problem28074 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String src = br.readLine();
        Set<Character> set = new HashSet<>();
        for (char c : src.toCharArray()) set.add(c);

        if (set.contains('M') && set.contains('O') && set.contains('B') && set.contains('I') && set.contains('S')) {
            System.out.print("YES");
        } else {
            System.out.print("NO");
        }

        br.close();
    }
}
