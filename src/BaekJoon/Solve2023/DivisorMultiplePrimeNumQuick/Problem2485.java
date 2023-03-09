package BaekJoon.Solve2023.DivisorMultiplePrimeNumQuick;

import java.io.*;
import java.util.Arrays;

public class Problem2485 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int treeCnt = Integer.parseInt(br.readLine());
        int[] treeArr = new int[treeCnt];

        for(int i = 0; i < treeCnt; i++) {
            treeArr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(treeArr);

        int[] intervals = new int[treeCnt - 1];
        for(int i = 0; i < treeCnt - 1; i++) {
            intervals[i] = treeArr[i + 1] - treeArr[i];
        }

        int resultInterval = getTotalLCD(intervals);
        int result = 0;

        for (int i = 1, port = treeArr[0], j = 1; i < treeCnt; i++) {
            while(port + j * resultInterval < treeArr[i]) {
                result++;
                j++;
            }
            port = treeArr[i];
            j = 1;
        }

        bw.write(String.valueOf(result));

        br.close();
        bw.close();
    }

    private int getTotalLCD(int[] arr) {
        int lcd = arr[0];

        for (int i = 1; i < arr.length; i++) {
            lcd = getLCD(arr[i], lcd);
        }

        return lcd;
    }

    private int getLCD(int a, int b) {
        int big = Math.max(a, b);
        int small = Math.min(a, b);

        while (big % small != 0) {
            int tmp = big % small;
            big = small;
            small = tmp;
        }

        return small;
    }
}
