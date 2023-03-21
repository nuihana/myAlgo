package BaekJoon.Solve2023.Bruteforce;

import java.io.*;
import java.util.StringTokenizer;

public class Problem19532 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        int f = Integer.parseInt(st.nextToken());

        for (int x = -999; x < 1000; x++) {
            boolean flag = false;
            for (int y = -999; y < 1000; y++) {
                if (x * a + y * b == c && x * d + y * e == f) {
                    bw.write(x + " " + y);
                    flag = true;
                    break;
                }
            }
            if (flag) {
                break;
            }
        }

        br.close();
        bw.close();
    }
}
