package BaekJoon.Solve2023.August.Conte_Arena2nd;

import java.io.*;

public class Problem28701 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int sum = sum(n);
        int sumDouble = sum * sum;
        int triplePowSum = triplePowSum(n);

        bw.write(String.valueOf(sum));
        bw.newLine();
        bw.write(String.valueOf(sumDouble));
        bw.newLine();
        bw.write(String.valueOf(triplePowSum));
        bw.newLine();

        br.close();
        bw.close();
    }

    private int sum(int n) {
        if (n == 1) return n;
        return n + sum(n - 1);
    }

    private int triplePowSum(int n) {
        if (n == 1) return n;
        return n * n * n + triplePowSum(n - 1);
    }
}
