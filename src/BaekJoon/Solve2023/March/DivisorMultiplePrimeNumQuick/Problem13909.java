package BaekJoon.Solve2023.March.DivisorMultiplePrimeNumQuick;

import java.io.*;

public class Problem13909 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine());

        bw.write(String.valueOf(Math.floor(Math.sqrt(num))));

        br.close();
        bw.close();
    }
}
