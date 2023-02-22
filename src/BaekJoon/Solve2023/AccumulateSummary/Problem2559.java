package BaekJoon.Solve2023.AccumulateSummary;

import java.io.*;
import java.util.StringTokenizer;

public class Problem2559 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int valCnt = Integer.parseInt(st.nextToken());
        int sumCnt = Integer.parseInt(st.nextToken());
        int[] valArr = new int[valCnt];
        int[] sumArr = new int[valCnt - sumCnt + 1];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; st.hasMoreTokens(); i++) {
            valArr[i] = Integer.parseInt(st.nextToken());
        }

        int sum = 0;

        for (int i = 0; i < sumCnt; i++) {
            sum += valArr[i];
        }

        sumArr[0] = sum;

        for (int i = 1, limit = valCnt - sumCnt + 1; i < limit; i++) {
            sumArr[i] = sum = sum - valArr[i - 1] + valArr[i + sumCnt - 1];
        }

        int max = Integer.MIN_VALUE;

        for (int i = 0; i < sumArr.length; i++) {
            max = Math.max(max, sumArr[i]);
        }

        bw.write(Integer.toString(max));

        br.close();
        bw.close();
    }
}
