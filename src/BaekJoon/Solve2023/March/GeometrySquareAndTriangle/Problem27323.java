package BaekJoon.Solve2023.March.GeometrySquareAndTriangle;

import java.io.*;

public class Problem27323 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int height = Integer.parseInt(br.readLine());
        int width = Integer.parseInt(br.readLine());

        bw.write(String.valueOf(height * width));

        br.close();
        bw.close();
    }
}
