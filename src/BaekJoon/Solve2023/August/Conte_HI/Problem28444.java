package BaekJoon.Solve2023.August.Conte_HI;

import java.io.*;
import java.util.StringTokenizer;

public class Problem28444 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int h = Integer.parseInt(st.nextToken());
        int i = Integer.parseInt(st.nextToken());
        int a = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        bw.write(String.valueOf(h * i - a * r * c));

        br.close();
        bw.close();
    }
}
