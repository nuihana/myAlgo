package BaekJoon.Solve2026.Feburary.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Problem29731 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        Set<String> set = new HashSet<>();
        set.add("Never gonna give you up");
        set.add("Never gonna let you down");
        set.add("Never gonna run around and desert you");
        set.add("Never gonna make you cry");
        set.add("Never gonna say goodbye");
        set.add("Never gonna tell a lie and hurt you");
        set.add("Never gonna stop");
        boolean isFake = false;
        for (int i = 0; i < n; i++) {
            String src = br.readLine();
            if (!set.contains(src)) isFake = true;
        }

        if (isFake) System.out.print("Yes");
        else System.out.print("No");

        br.close();
    }
}
