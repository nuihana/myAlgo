package BaekJoon.Solve2024.March.Sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Problem1431 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int cnt = Integer.parseInt(br.readLine());
        List<String> list = new ArrayList<>();
        while (cnt-- > 0) {
            list.add(br.readLine());
        }

        list.sort((s1, s2) -> {
            if (s1.length() != s2.length()) return s1.length() - s2.length();
            if (getNumVal(s1) != getNumVal(s2)) return getNumVal(s1) - getNumVal(s2);
            return s1.compareTo(s2);
        });

        for (String str : list) {
            System.out.println(str);
        }

        br.close();
    }

    private int getNumVal(String src) {
        int res = 0;
        for (int i = 0; i < src.length(); i++) {
            char c = src.charAt(i);
            if (c >= '0' && c <= '9') {
                res += c - '0';
            }
        }
        return res;
    }
}
