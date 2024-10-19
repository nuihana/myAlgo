package BaekJoon.Solve2024.October.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem2460 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int max = 0;
        int stat = 0;
        for (int i = 0; i < 10; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int off = Integer.parseInt(st.nextToken());
            int ride = Integer.parseInt(st.nextToken());

            stat -= off;
            stat += ride;

            max = Math.max(max, stat);
        }
        System.out.print(max);

        br.close();
    }
}
