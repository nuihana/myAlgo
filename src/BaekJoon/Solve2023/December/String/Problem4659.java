package BaekJoon.Solve2023.December.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Problem4659 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        while (true) {
            String src = br.readLine();
            if (src.equals("end")) break;

            boolean chk1 = false;
            boolean chk2 = true;
            boolean chk3 = true;
            Queue<Character> que = new LinkedList<>();
            char before = '0';
            for (int i = 0; i < src.length(); i++) {
                char c = src.charAt(i);
                if (isVowel(c)) chk1 = true;

                if (que.isEmpty()) {
                    que.offer(c);
                } else {
                    if (isVowel(que.peek()) && !isVowel(c) || !isVowel(que.peek()) && isVowel(c)) que.clear();
                    que.offer(c);
                }

                if (que.size() >= 3) {
                    chk2 = false;
                    break;
                }

                if (before != '0') {
                    if (before == c && c != 'e' && c != 'o') {
                        chk3 = false;
                        break;
                    }
                }
                before = c;
            }

            sb.append("<").append(src).append("> is ");
            if (!chk1 || !chk2 || !chk3) sb.append("not");
            sb.append(" acceptable.\n");
        }

        System.out.print(sb);

        br.close();
    }

    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}
