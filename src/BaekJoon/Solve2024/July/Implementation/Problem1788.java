package BaekJoon.Solve2024.July.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem1788 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        if (n > 0) {
            Integer[] fbnc = new Integer[n + 1];
            fbnc[0] = 0;
            fbnc[1] = 1;

            System.out.println(1);
            System.out.print(positiveFibonacci(n, fbnc));
        } else if (n < 0) {
            n *= -1;

            Integer[] fbnc = new Integer[n + 1];
            fbnc[0] = 0;
            fbnc[1] = 1;

            int val = negativeFibonacci(n, fbnc);
            System.out.println(val > 0 ? 1 : -1);
            System.out.print(Math.abs(val));
        } else {
            System.out.println(0);
            System.out.print(0);
        }

        br.close();
    }

    private int positiveFibonacci(int i, Integer[] arr) {
        if (arr[i] != null) return arr[i];
        return arr[i] = (positiveFibonacci(i - 1, arr) + positiveFibonacci(i - 2, arr)) % 1000000000;
    }

    private int negativeFibonacci(int i, Integer[] arr) {
        if (arr[i] != null) return arr[i];
        return arr[i] = (negativeFibonacci(i - 2, arr) - negativeFibonacci(i - 1, arr)) % 1000000000;
    }
}
