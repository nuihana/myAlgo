package BaekJoon.Solve2026.January.BruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem15721 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tot = Integer.parseInt(br.readLine());
        int nth = Integer.parseInt(br.readLine());
        int bd = Integer.parseInt(br.readLine()); // 0 : b, 1 : d

        int idx = 1, bCnt = 0, dCnt = 0, now = 0;
        while (true) {
            bCnt++;
            if (isDone(nth, bd, bCnt, dCnt)) break;
            now = (now + 1) % tot;

            dCnt++;
            if (isDone(nth, bd, bCnt, dCnt)) break;
            now = (now + 1) % tot;

            bCnt++;
            if (isDone(nth, bd, bCnt, dCnt)) break;
            now = (now + 1) % tot;

            dCnt++;
            if (isDone(nth, bd, bCnt, dCnt)) break;
            now = (now + 1) % tot;

            boolean isDone = false;
            for (int i = 0; i < idx + 1; i++) {
                bCnt++;
                if (isDone(nth, bd, bCnt, dCnt)) {
                    isDone = true;
                    break;
                }
                now = (now + 1) % tot;
            }
            if (isDone) break;

            for (int i = 0; i < idx + 1; i++) {
                dCnt++;
                if (isDone(nth, bd, bCnt, dCnt)) {
                    isDone = true;
                    break;
                }
                now = (now + 1) % tot;
            }
            if (isDone) break;

            idx++;
        }
        System.out.print(now);

        br.close();
    }

    private boolean isDone(int nth, int bd, int bCnt, int dCnt) {
        if (bd == 0) {
            return nth == bCnt;
        } else {
            return nth == dCnt;
        }
    }
}
