package BaekJoon.DynamicPlanning;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem11054 {
    private int[] valArr;
    private Integer[] upDp;
    private Integer[] downDp;
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int input = Integer.parseInt(br.readLine());
        valArr = new int[input];
        upDp = new Integer[input];
        downDp = new Integer[input];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; st.hasMoreTokens(); i++) {
            valArr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < input; i++) {
            getUpSeq(i);
            getDownSeq(i);
        }

        int maximum = -1;
        for (int i = 0; i < input; i++) {
            maximum = Math.max(upDp[i] + downDp[i], maximum);
        }
        System.out.println(maximum - 1);

        br.close();
    }

    private int getUpSeq(int idx) {
        if (upDp[idx] == null) {
            upDp[idx] = 1;

            for (int i = idx - 1; i >= 0; i--) {
                if (valArr[i] < valArr[idx]) {
                    upDp[idx] = Math.max(upDp[idx], getUpSeq(i) + 1);
                }
            }
        }

        return upDp[idx];
    }

    private int getDownSeq(int idx) {
        if (downDp[idx] == null) {
            downDp[idx] = 1;

            for (int i = idx + 1; i < downDp.length; i++) {
                if (valArr[i] < valArr[idx]) {
                    downDp[idx] = Math.max(downDp[idx], getDownSeq(i) + 1);
                }
            }
        }

        return downDp[idx];
    }
}
