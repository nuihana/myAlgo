package BaekJoon.NumberAndCombinatorics;

import java.io.*;
import java.util.StringTokenizer;

public class Problem2004 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        bw.write(Integer.toString(getZeroCnt(n, m)));

        bw.close();
        br.close();
    }

    private int getZeroCnt(int n, int m) {
        int result = 0;

        int fiveCnt = 0;
        int twoCnt = 0;

        int tmp = n;
        while (tmp >= 5) {
            fiveCnt += tmp / 5;
            tmp /= 5;
        }

        tmp = n;
        while (tmp >= 2) {
            twoCnt += tmp / 2;
            tmp /= 2;
        }

        tmp = m;
        while (tmp >= 5) {
            fiveCnt -= tmp / 5;
            tmp /= 5;
        }

        tmp = m;
        while (tmp >= 2) {
            twoCnt -= tmp / 2;
            tmp /= 2;
        }

        tmp = n-m;
        while (tmp >= 5) {
            fiveCnt -= tmp / 5;
            tmp /= 5;
        }

        tmp = n-m;
        while (tmp >= 2) {
            twoCnt -= tmp / 2;
            tmp /= 2;
        }

        if (fiveCnt > twoCnt) {
            result = twoCnt;
        } else {
            result = fiveCnt;
        }

        return result;
    }
}
