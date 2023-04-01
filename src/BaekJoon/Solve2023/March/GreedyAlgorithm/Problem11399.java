package BaekJoon.Solve2023.March.GreedyAlgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem11399 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int valCnt = Integer.parseInt(br.readLine());
        int[] valArr = new int[valCnt];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < valCnt; i++) {
            valArr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(valArr);

        int result = 0;

        for (int i = 0; i < valArr.length; i++) {
            result += valArr[i] * (valCnt - i);
        }

        System.out.print(result);

        br.close();
    }
}
