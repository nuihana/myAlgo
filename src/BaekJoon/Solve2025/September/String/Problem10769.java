package BaekJoon.Solve2025.September.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem10769 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String src = br.readLine();

        int happyCnt = 0, sadCnt = 0;
        for (int i = 0; i < src.length(); i++) {
            char c = src.charAt(i);
            if (c == ':') {
                if (src.charAt(++i) == '-') {
                    char last = src.charAt(++i);
                    if (last == ')') {
                        happyCnt++;
                    } else if (last == '(') {
                        sadCnt++;
                    }
                }
            }
        }

        if (happyCnt == 0 && sadCnt == 0) {
            System.out.print("none");
        } else if (happyCnt == sadCnt) {
            System.out.print("unsure");
        } else if (happyCnt > sadCnt) {
            System.out.print("happy");
        } else if (sadCnt > happyCnt) {
            System.out.print("sad");
        }

        br.close();
    }
}
