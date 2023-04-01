package BaekJoon.Solve2023.March.GeometrySquareAndTriangle;

import java.io.*;

public class Problem10101 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int angst = Integer.parseInt(br.readLine());
        int angnd = Integer.parseInt(br.readLine());
        int angrd = Integer.parseInt(br.readLine());

        if (angst == 60 && angnd == 60 && angrd == 60) {
            bw.write("Equilateral");
        } else if (angst + angnd + angrd != 180) {
            bw.write("Error");
        } else if (angst != angnd && angnd != angrd && angst != angrd) {
            bw.write("Scalene");
        } else {
            bw.write("Isosceles");
        }

        br.close();
        bw.close();
    }
}
