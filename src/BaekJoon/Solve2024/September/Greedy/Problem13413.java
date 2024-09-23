package BaekJoon.Solve2024.September.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem13413 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (tc-- > 0) {
            int cnt = Integer.parseInt(br.readLine());
            char[] from = br.readLine().toCharArray();
            char[] to = br.readLine().toCharArray();

            int res = setSameCnt(from, to);
            res += setSameOrd(from, to);

            sb.append(res).append("\n");
        }
        System.out.print(sb);

        br.close();
    }

    private int setSameCnt(char[] from, char[] to) {
        int fromBCnt = 0;
        for (int i = 0; i < from.length; i++) {
            char c = from[i];
            if (c == 'B') fromBCnt++;
        }

        int toBCnt = 0;
        for (int i = 0; i < to.length; i++) {
            char c = to[i];
            if (c == 'B') toBCnt++;
        }

        if (fromBCnt == toBCnt) return 0;
        int res = Math.abs(toBCnt - fromBCnt);
        for (int i = 0, change = 0; i < from.length && change < res; i++) {
            if (from[i] != to[i]) {
                from[i] = to[i];
                change++;
            }
        }

        return res;
    }

    private int setSameOrd(char[] from, char[] to) {
        int res = 0;

        for (int i = 0; i < from.length; i++) {
            if (from[i] != to[i]) res++;
        }

        return res / 2;
    }
}
