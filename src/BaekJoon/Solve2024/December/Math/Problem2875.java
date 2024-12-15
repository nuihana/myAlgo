package BaekJoon.Solve2024.December.Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.StringTokenizer;

public class Problem2875 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int female = Integer.parseInt(st.nextToken());
        int male = Integer.parseInt(st.nextToken());
        int intern = Integer.parseInt(st.nextToken());

        int res = 0;
        while (female >= 2 && male >= 1) {
            res++;
            female -= 2;
            male -= 1;
        }

        intern -= (female + male);
        while (intern > 0) {
            res--;
            intern -= 3;
        }

        System.out.print(res);

        br.close();
    }
}
