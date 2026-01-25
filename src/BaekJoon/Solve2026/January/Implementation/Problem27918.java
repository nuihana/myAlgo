package BaekJoon.Solve2026.January.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem27918 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int dCnt = 0, pCnt = 0;
        while (n-- > 0) {
            String win = br.readLine();

            if ("D".equals(win)) {
                dCnt++;
            } else if ("P".equals(win)) {
                pCnt++;
            }

            if (Math.abs(dCnt - pCnt) >= 2) break;
        }
        System.out.print(dCnt + ":" + pCnt);

        br.close();
    }
}
