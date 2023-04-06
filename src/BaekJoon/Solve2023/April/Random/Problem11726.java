package BaekJoon.Solve2023.April.Random;

import java.io.*;

public class Problem11726 {
    int[] fibonacciArr = new int[1001];
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine());
        fibonacciArr[0] = 1;
        fibonacciArr[1] = 1;

        bw.write(String.valueOf(fibonacci(num)));

        br.close();
        bw.close();
    }

    private int fibonacci(int num) {
        if (fibonacciArr[num] > 0) {
            return fibonacciArr[num];
        }

        return fibonacciArr[num] = (fibonacci(num - 1) + fibonacci(num - 2)) % 10007;
    }
}
