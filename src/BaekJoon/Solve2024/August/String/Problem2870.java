package BaekJoon.Solve2024.August.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Problem2870 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        List<String> res = new ArrayList<>();
        int cnt = Integer.parseInt(br.readLine());
        while (cnt-- > 0) {
            String src = br.readLine();

            Queue<Character> q = new LinkedList<>();
            for (int i = 0; i < src.length(); i++) {
                char c = src.charAt(i);
                if (c >= '0' && c <= '9') {
                    q.offer(c);
                } else if (!q.isEmpty()) {
                    StringBuilder sb = new StringBuilder();
                    while (!q.isEmpty()) {
                        sb.append(q.poll());
                    }

                    res.add(removeZero(sb.toString()));
                }
            }

            if (!q.isEmpty()) {
                StringBuilder sb = new StringBuilder();
                while (!q.isEmpty()) {
                    sb.append(q.poll());
                }

                res.add(removeZero(sb.toString()));
            }
        }

        res.sort((s1, s2) -> {
            if (s1.length() != s2.length()) return s1.length() - s2.length();
            return s1.compareTo(s2);
        });
        StringBuilder sb = new StringBuilder();
        for (String val : res) {
            sb.append(val).append("\n");
        }

        System.out.print(sb);

        br.close();
    }

    private String removeZero(String src) {
        StringBuilder sb = new StringBuilder();
        boolean isLPAD = true;
        for (int i = 0; i < src.length(); i++) {
            if (src.charAt(i) != '0') isLPAD = false;
            if (!isLPAD) sb.append(src.charAt(i));
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }
}
