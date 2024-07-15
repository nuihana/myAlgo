package BaekJoon.Solve2024.July.Sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Problem15688 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int numCnt = Integer.parseInt(br.readLine());
        int maximum = 1000000;
        int[] cntArr = new int[maximum * 2 + 1];
        for (int i = 0; i < numCnt; i++) {
            int num = Integer.parseInt(br.readLine());
            cntArr[num + maximum]++;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= maximum * 2; i++) {
            if (cntArr[i] == 0) continue;
            while (cntArr[i]-- > 0) {
                sb.append(i - maximum).append("\n");
            }
        }
        System.out.print(sb);

        br.close();
    }
}
