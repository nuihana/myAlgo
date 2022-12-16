package BaekJoon.Backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem15651 {
    private int[] arrs;
    private StringBuilder sb = new StringBuilder();

    public void solution() throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bf.readLine());

        bf.close();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        arrs = new int[m];

        printNum(n, m, 0);

        System.out.print(sb.toString());
    }

    private void printNum(int maxNum, int size, int depth) {
        /*
         * 출력
         */
        if (size == depth) {
            for (int num : arrs) {
                sb.append(num).append(" ");
            }
            sb.append("\n");
            return;
        }

        /*
         * 재귀
         */
        for (int i = 1; i <= maxNum; i++) {
            arrs[depth] = i;
            printNum(maxNum, size, depth + 1);
        }
    }
}
