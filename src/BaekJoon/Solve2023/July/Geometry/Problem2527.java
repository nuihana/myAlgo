package BaekJoon.Solve2023.July.Geometry;

import java.io.*;
import java.util.*;

public class Problem2527 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while(true) {
            String line = br.readLine();
            if (line == null || line.equals("")) break;
            StringTokenizer st = new StringTokenizer(line);

            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            int dx1 = Integer.parseInt(st.nextToken());
            int dy1 = Integer.parseInt(st.nextToken());
            int dx2 = Integer.parseInt(st.nextToken());
            int dy2 = Integer.parseInt(st.nextToken());

            if (x2 < dx1 || y2 < dy1 || dx2 < x1 || dy2 < y1) {
                bw.write("d");
            }
            else if ((x1 == dx2 && y1 == dy2) || (x1 == dx2 && y2 == dy1) || (x2 == dx1 && y2 == dy1) || (x2 == dx1 && y1 == dy2)) {
                bw.write("c");
            }
            else if (x2 == dx1 || y2 == dy1|| dx2 == x1 || y1 == dy2){
                bw.write("b");
            }
            else {
                bw.write("a");
            }
            bw.newLine();
        }

        br.close();
        bw.close();
    }
}
