package BaekJoon.Solve2023.March.GreedyAlgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem13305 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int vilCnt = Integer.parseInt(br.readLine());
        int[] lengArr = new int[vilCnt - 1];
        int[] priceArr = new int[vilCnt];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < vilCnt - 1; i++) {
            lengArr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < vilCnt; i++) {
            priceArr[i] = Integer.parseInt(st.nextToken());
        }

        long result = 0;
        long bfPrice = Long.MIN_VALUE;
        long tmpLength = 0;
        for (int i = 0; i < vilCnt; i++) {
            if (i == 0) {
                bfPrice = priceArr[i];
            } else {
                if (bfPrice > priceArr[i]) {
                    tmpLength += lengArr[i - 1];
                    result += tmpLength * bfPrice;
                    tmpLength = 0;
                    bfPrice = priceArr[i];
                } else {
                    tmpLength += lengArr[i - 1];
                }
            }

            if (i == vilCnt - 1) {
                if (tmpLength != 0) {
                    result += tmpLength * bfPrice;
                }
            }
        }

        System.out.print(result);

        br.close();
    }
}
