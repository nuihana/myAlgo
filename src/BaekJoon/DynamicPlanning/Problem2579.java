package BaekJoon.DynamicPlanning;

import java.io.*;
import java.util.StringTokenizer;

public class Problem2579 {
    int[] valueArr;
    Integer[] cost;
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int inputCnt = Integer.parseInt(br.readLine());
        valueArr = new int[inputCnt];
        cost = new Integer[inputCnt];

        for (int i = 0; i < inputCnt; i++) {
            valueArr[i] = Integer.parseInt(br.readLine());
        }

        bw.write(Integer.toString(findRoute(inputCnt - 1)));

        br.close();
        bw.close();
    }

    private int findRoute(int idx) {
        if (cost[idx] != null) {
            return cost[idx];
        }

        return cost[idx] = Math.max(findRoute(idx - 2), findRoute(idx - 3) + valueArr[idx - 1]) + valueArr[idx];
    }
}
