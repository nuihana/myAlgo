package BaekJoon.Solve2023.GeometrySquareAndTriangle;

import java.io.*;
import java.util.StringTokenizer;

public class Problem14215 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int lenst = Integer.parseInt(st.nextToken());
        int lennd = Integer.parseInt(st.nextToken());
        int lenrd = Integer.parseInt(st.nextToken());

        int max = Math.max(lenst, Math.max(lennd, lenrd));

        if (lenst + lennd + lenrd - max <= max) {
            bw.write(String.valueOf((lenst + lennd + lenrd - max) * 2 - 1));
        } else {
            bw.write(String.valueOf(lenst + lennd + lenrd));
        }

        br.close();
        bw.close();
    }
}
