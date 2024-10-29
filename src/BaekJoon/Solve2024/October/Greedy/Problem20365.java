package BaekJoon.Solve2024.October.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem20365 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int bCnt = 0, rCnt = 0;
        String line = br.readLine();
        char bf = line.charAt(0);
        for (int i = 1; i < line.length(); i++) {
            char now = line.charAt(i);
            if (bf != now) {
                if (now == 'B') rCnt++;
                else bCnt++;

                bf = now;
            }
        }
        if (bf == 'B') bCnt++;
        else rCnt++;

        System.out.print(Math.min(bCnt, rCnt) + 1);

        br.close();
    }
}
