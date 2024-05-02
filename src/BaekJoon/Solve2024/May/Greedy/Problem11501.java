package BaekJoon.Solve2024.May.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem11501 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCase = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (testCase-- > 0) {
            int numCnt = Integer.parseInt(br.readLine());

            int[] numArr = new int[numCnt];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < numCnt; i++) {
                numArr[i] = Integer.parseInt(st.nextToken());
            }

            long res = 0;
            int bf = numArr[numCnt - 1];
            for (int i = numCnt - 2; i >= 0; i--) {
                if (numArr[i] < bf) {
                    res += bf - numArr[i];
                } else if (numArr[i] > bf) {
                    bf = numArr[i];
                }
            }

            sb.append(res).append("\n");
        }

        System.out.print(sb);

        br.close();
    }
}
