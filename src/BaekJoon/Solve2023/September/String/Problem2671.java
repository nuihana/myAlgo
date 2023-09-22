package BaekJoon.Solve2023.September.String;

import java.io.*;

public class Problem2671 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String pattern = "(100+1+|01)+";
        String str = br.readLine();
        bw.write(str.matches(pattern) ? "SUBMARINE" : "NOISE");
        bw.newLine();

        br.close();
        bw.close();
    }
}
