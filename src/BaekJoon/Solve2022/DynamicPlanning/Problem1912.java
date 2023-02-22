package BaekJoon.Solve2022.DynamicPlanning;

import java.io.*;
import java.util.StringTokenizer;

public class Problem1912 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int inputCnt = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int result = Integer.MIN_VALUE;
        int tmpSum = 0;

        while(st.hasMoreTokens()) {
            int tmp = Integer.parseInt(st.nextToken());

            tmpSum += tmp;

            if (tmpSum > result) {
                result = tmpSum;
            }

            if (tmpSum <= 0) {
                tmpSum = 0;
            }
        }

        bw.write(Integer.toString(result));

        br.close();
        bw.close();
    }
}
