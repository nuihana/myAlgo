package BaekJoon.Solve2023.GeometrySquareAndTriangle;

import java.io.*;
import java.util.StringTokenizer;

public class Problem5073 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int lenst = -1;
        int lennd = -1;
        int lenrd = -1;

        while (lenst != 0 && lennd != 0 && lenrd !=0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            lenst = Integer.parseInt(st.nextToken());
            lennd = Integer.parseInt(st.nextToken());
            lenrd = Integer.parseInt(st.nextToken());

            if (lenst == 0 || lennd == 0 || lenrd == 0) {
                break;
            }

            int max = Math.max(lenst, Math.max(lennd, lenrd));

            if (lenst == lennd && lennd == lenrd && lenst == lenrd) {
                bw.write("Equilateral");
            } else if (max >= lenst + lennd + lenrd - max) {
                bw.write("Invalid");
            } else if (lenst != lennd && lennd != lenrd && lenst != lenrd) {
                bw.write("Scalene");
            } else if (lenst == lennd || lennd == lenrd || lenst == lenrd) {
                bw.write("Isosceles");
            }
            bw.newLine();
        }

        br.close();
        bw.close();
    }
}
