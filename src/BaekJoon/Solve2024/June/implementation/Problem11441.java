package BaekJoon.Solve2024.June.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem11441 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int numCnt = Integer.parseInt(br.readLine());
        int[] numArr = new int[numCnt];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < numCnt; i++) {
            numArr[i] = Integer.parseInt(st.nextToken());
        }

        int[] sum = new int[numCnt + 1];
        sum[1] = numArr[0];
        for (int i = 2; i <= numCnt; i++) {
            sum[i] = sum[i - 1] + numArr[i - 1];
        }

        StringBuilder sb = new StringBuilder();
        int queryCnt = Integer.parseInt(br.readLine());
        while (queryCnt-- > 0) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            sb.append(sum[to] - sum[from - 1]).append("\n");
        }

        System.out.print(sb);

        br.close();
    }
}
