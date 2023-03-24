package BaekJoon.Solve2023.BasicMath_1;

import java.io.*;

public class Problem2903 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine());
        int pow = (int) Math.pow(2, num);
        bw.write(String.valueOf((int) Math.pow(pow + 1, 2)));

        br.close();
        bw.close();
    }
}
