package BaekJoon.Solve2024.December.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Problem1283 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        Set<Character> charSet = new HashSet<>();
        for (int i = 0; i < n; i++) {
            String func = br.readLine();
            String lowerFunc = func.toLowerCase();

            int idx = find(charSet, lowerFunc);
            if (idx != -1) {
                charSet.add(lowerFunc.charAt(idx));
                for (int j = 0; j < func.length(); j++) {
                    if (j == idx) {
                        sb.append("[").append(func.charAt(j)).append("]");
                    } else {
                        sb.append(func.charAt(j));
                    }
                }
                sb.append("\n");
            } else {
                sb.append(func).append("\n");
            }
        }
        System.out.print(sb);

        br.close();
    }

    private int find(Set<Character> charSet, String func) {
        //첫글자
        if (!charSet.contains(func.charAt(0))) return 0;
        for (int i = 1; i < func.length(); i++) {
            if (func.charAt(i) == ' ') {
                if (!charSet.contains(func.charAt(i + 1))) return i + 1;
            }
        }
        //전체
        for (int i = 0; i < func.length(); i++) {
            if (!charSet.contains(func.charAt(i)) && func.charAt(i) != ' ') return i;
        }
        return -1;
    }
}
