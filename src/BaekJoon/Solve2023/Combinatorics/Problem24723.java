package BaekJoon.Solve2023.Combinatorics;

import java.io.*;

public class Problem24723 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        bw.write(String.valueOf(Math.pow(2, n)));

        br.close();
        bw.close();
    }
}
