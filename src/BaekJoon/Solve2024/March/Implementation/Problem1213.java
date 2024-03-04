package BaekJoon.Solve2024.March.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Problem1213 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String src = br.readLine();
        int[] cntArr = new int[26];
        for (int i = 0; i < src.length(); i++) {
            char c = src.charAt(i);
            cntArr[c - 'A']++;
        }

        boolean impossible = false;
        StringBuilder sb = new StringBuilder();
        if (src.length() % 2 == 0) {
            for (int i = 0; i < 26; i++) {
                if (cntArr[i] % 2 != 0) {
                    impossible = true;
                    break;
                }
            }

            if (!impossible) {
                for (int i = 0; i < 26; i++) {
                    if (cntArr[i] > 0) {
                        char c = (char) (i + 'A');
                        for (int j = 0; j < cntArr[i] / 2; j++) sb.append(c);
                    }
                }

                String reverse = sb.reverse().toString();
                sb.reverse();
                sb.append(reverse);
            }
        } else {
            List<Integer> oddList = new ArrayList<>();
            for (int i = 0; i < 26; i++) {
                if (cntArr[i] % 2 != 0) {
                    oddList.add(i);
                }
            }

            if (oddList.size() > 1) {
                impossible = true;
            }

            if (!impossible) {
                for (int i = 0; i < 26; i++) {
                    if (cntArr[i] > 0 && (!oddList.contains(i) || cntArr[i] > 2)) {
                        char c = (char) (i + 'A');
                        for (int j = 0; j < cntArr[i] / 2; j++) sb.append(c);
                    }
                }

                String reverse = sb.reverse().toString();
                sb.reverse();
                sb.append((char) (oddList.get(0) + 'A'));
                sb.append(reverse);
            }
        }

        if (impossible) System.out.print("I'm Sorry Hansoo");
        else System.out.print(sb);

        br.close();
    }
}
