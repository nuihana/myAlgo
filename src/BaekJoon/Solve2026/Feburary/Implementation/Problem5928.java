package BaekJoon.Solve2026.Feburary.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem5928 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int d = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        if (d < 11 || (d == 11 && h < 11) || (d == 11 && h == 11 && m < 11)) {
            System.out.print(-1);
        } else {
            System.out.print((d - 11) * 24 * 60 + (h - 11) * 60 + (m - 11));
        }

        br.close();
    }
}
