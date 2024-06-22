package BaekJoon.Solve2024.June.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Problem2012 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int stuCnt = Integer.parseInt(br.readLine());
        int[] students = new int[stuCnt];
        for (int i = 0; i < stuCnt; i++) {
            students[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(students);

        long res = 0;
        for (int i = 0; i < stuCnt; i++) {
            res += Math.abs(students[i] - (i + 1));
        }

        System.out.print(res);

        br.close();
    }
}
