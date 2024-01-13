package BaekJoon.Solve2024.January.Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Problem9613 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCaseCnt = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (testCaseCnt-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int numCnt = Integer.parseInt(st.nextToken());
            int[] numArr = new int[numCnt];
            for (int i = 0; i < numCnt; i++) {
                numArr[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(numArr);

            long res = 0;
            for (int i = 0; i < numCnt; i++) {
                for (int j = i + 1; j < numCnt; j++) {
                    res += GCD(numArr[j], numArr[i]);
                }
            }

            sb.append(res).append("\n");
        }

        System.out.print(sb);

        br.close();
    }

    private int GCD(int a, int b) {
        if (a % b == 0) return b;
        return GCD(b, a % b);
    }
}
