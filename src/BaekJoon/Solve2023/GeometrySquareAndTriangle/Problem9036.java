package BaekJoon.Solve2023.GeometrySquareAndTriangle;

import java.io.*;
import java.util.StringTokenizer;

public class Problem9036 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int count = Integer.parseInt(br.readLine());

        int minHeight = 10000;
        int minWidth = 10000;
        int maxHeight = -10000;
        int maxWidth = -10000;

        for (int i = 0; i < count; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            minWidth = Math.min(minWidth, x);
            maxWidth = Math.max(maxWidth, x);
            minHeight = Math.min(minHeight, y);
            maxHeight = Math.max(maxHeight, y);
        }

        bw.write(String.valueOf((maxWidth - minWidth) * (maxHeight - minHeight)));

        br.close();
        bw.close();
    }
}
