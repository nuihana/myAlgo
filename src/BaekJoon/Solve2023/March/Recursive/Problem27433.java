package BaekJoon.Solve2023.March.Recursive;

import java.io.*;

public class Problem27433 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine());

        bw.write(String.valueOf(factorial(num)));

        br.close();
        bw.close();
    }

    private long factorial(int num) {
        if (num == 0) {
            return 1;
        }

        return num * factorial(num - 1);
    }
}
