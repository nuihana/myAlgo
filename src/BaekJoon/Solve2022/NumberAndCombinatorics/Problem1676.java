package BaekJoon.Solve2022.NumberAndCombinatorics;

import java.io.*;

public class Problem1676 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int input = Integer.parseInt(br.readLine());
        int zeroCnt = 0;

        while (input >= 5) {
            zeroCnt += input / 5;
            input /= 5;
        }

        bw.write(Integer.toString(zeroCnt));

        bw.close();
        br.close();
    }
}
