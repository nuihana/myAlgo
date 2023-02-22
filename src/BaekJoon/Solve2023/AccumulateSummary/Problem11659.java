package BaekJoon.Solve2023.AccumulateSummary;

import java.io.*;
import java.util.StringTokenizer;

public class Problem11659 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int numCnt = Integer.parseInt(st.nextToken());
        int sumCnt = Integer.parseInt(st.nextToken());

        int[] inputArr = new int[numCnt];
        int[] toSumArr = new int[numCnt];

        st = new StringTokenizer(br.readLine());
        for (int i = 0, sum = 0; i < numCnt; i++) {
            inputArr[i] = Integer.parseInt(st.nextToken());
            toSumArr[i] = sum += inputArr[i];
        }

        for (int i = 0; i < sumCnt; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            if (from == 1) {
                bw.write(toSumArr[to - 1] + "\n");
            } else {
                bw.write(toSumArr[to - 1] - toSumArr[from - 2] + "\n");
            }
        }

        br.close();
        bw.close();
    }
}
