package BaekJoon.Solve2023.October.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem11585 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        char[] src = new char[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            src[i] = st.nextToken().charAt(0);
        }
        char[] cmp = new char[n * 2 - 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            cmp[i] = st.nextToken().charAt(0);
        }
        System.arraycopy(cmp, 0, cmp, n, n - 1);

        int[] table = makeTable(src);
        int possibleCnt = 0;
        int idx = 0;
        for (int i = 0; i < cmp.length; i++) {
            while (idx > 0 && cmp[i] != src[idx]) {
                idx = table[idx - 1];
            }

            if (cmp[i] == src[idx]) {
                if (idx == n - 1) {
                    possibleCnt++;
                    idx = table[idx];
                } else {
                    idx++;
                }
            }
        }

        int gcd = GCD(n, possibleCnt);
        System.out.print((possibleCnt / gcd) + "/" + (n / gcd));

        br.close();
    }

    private int GCD(int a, int b) {
        if (b == 0) return a;
        return GCD(b, a % b);
    }

    private int[] makeTable(char[] src) {
        int[] res = new int[src.length];

        int idx = 0;
        for (int i = 1; i < src.length; i++) {
            while (idx > 0 && src[i] != src[idx]) {
                idx = res[idx - 1];
            }

            if (src[i] == src[idx]) {
                res[i] = ++idx;
            }
        }

        return res;
    }
}
