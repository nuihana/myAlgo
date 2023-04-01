package BaekJoon.Solve2023.March.DivisorMultiplePrimeNum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem2501 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int num = Integer.parseInt(st.nextToken());
        int ord = Integer.parseInt(st.nextToken());
        int[] divisorArr = new int[10000];

        for (int i = 1, j = 0; i <= num; i++) {
            if (num % i == 0) {
                divisorArr[j] = i;
                j++;
            }
        }

        System.out.print(divisorArr[ord - 1] == 0 ? 0 : divisorArr[ord - 1]);

        br.close();
    }
}
