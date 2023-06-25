package BaekJoon.Solve2023.June.Random;

import java.io.*;
import java.util.*;

public class Problem1002 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int caseCnt = Integer.parseInt(br.readLine());
        for (int i = 0; i < caseCnt; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int len1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int len2 = Integer.parseInt(st.nextToken());

            double between = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
            if (between == 0 && len1 == len2) {
                bw.write("-1");
            } else if (between > len1 + len2 || between + Math.min(len1, len2) < Math.max(len1, len2)) {
                bw.write("0");
            } else if (between == len1 + len2 || Math.max(len1, len2) == between + Math.min(len1, len2)) {
                bw.write("1");
            } else {
                bw.write("2");
            }
            bw.newLine();
        }

        br.close();
        bw.close();
    }
}
