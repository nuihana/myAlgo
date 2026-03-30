package BaekJoon.Solve2026.March.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class Problem14468 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String src = br.readLine();
        int res = 0, top = 0;
        Set<Character> set = new HashSet<>();
        char[] stack = new char[53];
        for (char c : src.toCharArray()) {
            if (!set.contains(c)) {
                set.add(c);
                stack[top++] = c;
            } else {
                int idx = top - 1;
                while (stack[idx] != c) idx--;
                res += top - idx - 1;

                for (int i = idx; i < top; i++) {
                    stack[i] = stack[i + 1];
                }
                top--;
            }
        }
        System.out.print(res);

        br.close();
    }
}
