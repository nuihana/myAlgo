package BaekJoon.Solve2025.June;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem5586 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String src = br.readLine();
        int jCnt = 0;
        int iCnt = 0;
        for (int i = 0; i < src.length(); i++) {
            char c = src.charAt(i);

            if (c == 'O' && i > 0 && i < src.length() - 1) {
                if (src.charAt(i - 1) == 'J' && src.charAt(i + 1) == 'I') {
                    jCnt++;
                }

                if (src.charAt(i - 1) == 'I' && src.charAt(i + 1) == 'I') {
                    iCnt++;
                }
            }
        }
        System.out.println(jCnt);
        System.out.print(iCnt);

        br.close();
    }
}
