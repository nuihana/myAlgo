package BaekJoon.Solve2023.September.String;

import java.io.*;
import java.util.Stack;

public class Problem16120 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = br.readLine();
        String result = "PPAP";
        int pCnt = 0;
        boolean aFlag = false;
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == 'P') {
                if (aFlag) {
                    if (pCnt < 2) {
                        result = "NP";
                        break;
                    }
                    pCnt--;
                    aFlag = false;
                } else {
                    pCnt++;
                }
            }

            if (c == 'A') {
                if (aFlag) {
                    result = "NP";
                    break;
                }
                aFlag = true;
            }
        }

        if (pCnt > 1 || aFlag) result = "NP";

        bw.write(result);

        br.close();
        bw.close();
    }
}
