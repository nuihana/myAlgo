package BaekJoon.Solve2023.September.Geometry;

import java.io.*;
import java.util.StringTokenizer;

public class Problem12781 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] p1 = new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
        int[] p2 = new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
        int[] p3 = new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
        int[] p4 = new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};

        if (ccw(p1, p2, p3) * ccw(p1, p2, p4) < 0) bw.write("1");
        else bw.write("0");

        br.close();
        bw.close();
    }

    private int ccw(int[] p1, int[] p2, int[] p3) {
        int res = (p2[0] - p1[0])*(p3[1] - p1[1]) - (p2[1] - p1[1])*(p3[0] - p1[0]);
        return Integer.signum(res);
    }
}
