package BaekJoon.Solve2022.DynamicPlanning;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem24416 {
    int[] fibArr = new int[40];
    int roopCnt = 0;
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int input = Integer.parseInt(br.readLine());

        fibArr[0] = 1;
        fibArr[1] = 1;

        int result_val = fibonacci(input);

        System.out.print(result_val + " " + roopCnt);

        br.close();
    }

    private int fibonacci(int val) {
        if (fibArr[val - 1] != 0) {
            return fibArr[val - 1];
        } else {
            roopCnt++;
            return fibArr[val - 1] = (fibonacci(val - 1) + fibonacci(val - 2));
        }
    }
}
