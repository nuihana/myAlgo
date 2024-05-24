package BaekJoon.Solve2024.May.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem1022 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int lr = Integer.parseInt(st.nextToken());
        int lc = Integer.parseInt(st.nextToken());
        int rr = Integer.parseInt(st.nextToken());
        int rc = Integer.parseInt(st.nextToken());

        int maxLen = -1;
        for (int i = lr; i <= rr; i++) {
            for (int j = lc; j <= rc; j++) {
                maxLen = Math.max(maxLen, numLen(getNum(i, j)));
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = lr; i <= rr; i++) {
            for (int j = lc; j <= rc; j++) {
                sb.append(fitNum(maxLen, getNum(i, j))).append(" ");
            }
            sb.append("\n");
        }

        System.out.print(sb);

        br.close();
    }

    private String fitNum(int len, int val) {
        StringBuilder sb = new StringBuilder();
        int valLen = numLen(val);
        sb.append(" ".repeat(Math.max(0, len - valLen)));
        sb.append(val);
        return sb.toString();
    }

    private int numLen(int val) {
        if (val > 0) return numLen(val / 10) + 1;
        return 0;
    }

    private int getNum(int r, int c) {
        int n = Math.max(Math.abs(r), Math.abs(c));
        int val = (2 * n + 1);
        val *= val;

        int diff = 2 * n;
        if (r == n)return val - (n - c);
        val -= diff;
        if (c == -n)return val - (n - r);
        val -= diff;
        if (r == -n)return val - (c + n);
        val -= diff;
        return val - (r + n);
    }
}
