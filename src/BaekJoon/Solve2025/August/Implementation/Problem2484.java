package BaekJoon.Solve2025.August.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem2484 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int res = 0;
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            res = Math.max(res, score(a, b, c, d));
        }
        System.out.print(res);

        br.close();
    }

    private int score(int a, int b, int c, int d) {
        int[] cnt = new int[6 + 1];
        cnt[a]++;
        cnt[b]++;
        cnt[c]++;
        cnt[d]++;

        int res = chkQuad(cnt);
        if (res > 0) return 50000 + res * 5000;

        res = chkTriple(cnt);
        if (res > 0) return 10000 + res * 1000;

        res = chkDouble(cnt);
        if (chkDoubleCnt(cnt) == 2) {
            return 2000 + res * 500;
        } else if (chkDoubleCnt(cnt) == 1) {
            return 1000 + res * 100;
        }

        return Math.max(a, Math.max(b, Math.max(c, d))) * 100;
    }
    
    private int chkQuad(int[] cnt) {
        for (int i = 1; i <= 6; i++) {
            if (cnt[i] == 4) return i;
        }
        return 0;
    }
    private int chkTriple(int[] cnt) {
        for (int i = 1; i <= 6; i++) {
            if (cnt[i] == 3) return i;
        }
        return 0;
    }
    private int chkDoubleCnt(int[] cnt) {
        int res = 0;
        for (int i = 1; i <= 6; i++) {
            if (cnt[i] == 2) res++;
        }
        return res;
    }
    private int chkDouble(int[] cnt) {
        int res = 0;
        for (int i = 1; i <= 6; i++) {
            if (cnt[i] == 2) res += i;
        }
        return res;
    }
}
