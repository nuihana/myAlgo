package BaekJoon.Solve2024.May.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem12891 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int srcLength = Integer.parseInt(st.nextToken());
        int resLength = Integer.parseInt(st.nextToken());

        String src = br.readLine();

        st = new StringTokenizer(br.readLine());
        int aCnt = Integer.parseInt(st.nextToken());
        int cCnt = Integer.parseInt(st.nextToken());
        int gCnt = Integer.parseInt(st.nextToken());
        int tCnt = Integer.parseInt(st.nextToken());

        int res = 0;
        int[] cnt = new int[4]; // 0 : a, 1 : c, 2 : g, 3 : t
        int l = 0, r = resLength - 1;
        for (int i = l; i <= r; i++) {
            char c = src.charAt(i);
            if (c == 'A') cnt[0]++;
            if (c == 'C') cnt[1]++;
            if (c == 'G') cnt[2]++;
            if (c == 'T') cnt[3]++;
        }

        if (cnt[0] >= aCnt && cnt[1] >= cCnt && cnt[2] >= gCnt && cnt[3] >= tCnt) {
            res++;
        }

        while (++r < srcLength) {
            char lc = src.charAt(l++);
            char rc = src.charAt(r);

            if (lc == 'A') cnt[0]--;
            if (lc == 'C') cnt[1]--;
            if (lc == 'G') cnt[2]--;
            if (lc == 'T') cnt[3]--;

            if (rc == 'A') cnt[0]++;
            if (rc == 'C') cnt[1]++;
            if (rc == 'G') cnt[2]++;
            if (rc == 'T') cnt[3]++;

            if (cnt[0] >= aCnt && cnt[1] >= cCnt && cnt[2] >= gCnt && cnt[3] >= tCnt) {
                res++;
            }
        }

        System.out.print(res);

        br.close();
    }
}
