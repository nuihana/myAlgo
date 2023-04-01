package BaekJoon.Solve2023.March.GreedyAlgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem11047 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int valCnt = Integer.parseInt(st.nextToken());
        int resVal = Integer.parseInt(st.nextToken());
        int[] valArr = new int[valCnt];

        for (int i = 0; i < valCnt; i++) {
            valArr[i] = Integer.parseInt(br.readLine());
        }

        int result = 0;

        for (int i = valCnt - 1; i >= 0; i--) {
            if (resVal >= valArr[i]) {
                int tmp = resVal / valArr[i];
                result += tmp;
                resVal -= tmp * valArr[i];
            }
        }

        System.out.print(result);

        br.close();
    }
}
