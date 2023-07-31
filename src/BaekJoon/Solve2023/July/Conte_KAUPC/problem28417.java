package BaekJoon.Solve2023.July.Conte_KAUPC;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class problem28417 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int cnt = Integer.parseInt(br.readLine());
        int res = 0;
        while(cnt-- > 0) {
            int score = 0;

            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] run = new int[2];
            run[0] = Integer.parseInt(st.nextToken());
            run[1] = Integer.parseInt(st.nextToken());
            Arrays.sort(run);
            score += run[1];

            int[] trick = new int[5];
            trick[0] = Integer.parseInt(st.nextToken());
            trick[1] = Integer.parseInt(st.nextToken());
            trick[2] = Integer.parseInt(st.nextToken());
            trick[3] = Integer.parseInt(st.nextToken());
            trick[4] = Integer.parseInt(st.nextToken());
            Arrays.sort(trick);
            score += trick[4];
            score += trick[3];

            res = Math.max(res, score);
        }
        bw.write(String.valueOf(res));

        br.close();
        bw.close();
    }
}
