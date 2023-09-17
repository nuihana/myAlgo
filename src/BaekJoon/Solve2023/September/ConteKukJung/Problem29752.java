package BaekJoon.Solve2023.September.ConteKukJung;

import java.io.*;
import java.util.StringTokenizer;

public class Problem29752 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int res = 0;
        int strick = 0;
        while (n-- > 0) {
            int now = Integer.parseInt(st.nextToken());

            if (now > 0) strick++;
            else strick = 0;
            res = Math.max(res, strick);
        }

        bw.write(String.valueOf(res));

        br.close();
        bw.close();
    }
}
