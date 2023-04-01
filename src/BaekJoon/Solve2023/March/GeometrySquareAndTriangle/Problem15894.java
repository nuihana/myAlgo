package BaekJoon.Solve2023.March.GeometrySquareAndTriangle;

import java.io.*;

public class Problem15894 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int count = Integer.parseInt(br.readLine());

        bw.write(String.valueOf(count * 4));

        br.close();
        bw.close();
    }
}
