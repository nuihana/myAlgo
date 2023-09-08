package BaekJoon.Solve2023.September.Random;

import java.io.*;
import java.util.StringTokenizer;

public class Problem2420 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        bw.write(String.valueOf(Math.abs(a - b)));

        br.close();
        bw.close();
    }
}
