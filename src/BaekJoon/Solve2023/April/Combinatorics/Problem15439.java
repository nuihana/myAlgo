package BaekJoon.Solve2023.April.Combinatorics;

import java.io.*;

public class Problem15439 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int var = Integer.parseInt(br.readLine());

        bw.write(String.valueOf(var * (var - 1)));

        br.close();
        bw.close();
    }
}
