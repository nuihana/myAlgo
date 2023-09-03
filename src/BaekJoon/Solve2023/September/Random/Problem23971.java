package BaekJoon.Solve2023.September.Random;

import java.io.*;
import java.util.StringTokenizer;

public class Problem23971 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int x = w % (m + 1) == 0 ? w / (m + 1) : w / (m + 1) + 1;
        int y = h % (n + 1) == 0 ? h / (n + 1) : h / (n + 1) + 1;
        int res = x * y;
        bw.write(String.valueOf(res));

        br.close();
        bw.close();
    }
}
