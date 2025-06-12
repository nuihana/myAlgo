package BaekJoon.Solve2025.June.Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem24736 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 2; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int res = 0;

            res += Integer.parseInt(st.nextToken()) * 6;
            res += Integer.parseInt(st.nextToken()) * 3;
            res += Integer.parseInt(st.nextToken()) * 2;
            res += Integer.parseInt(st.nextToken()) * 1;
            res += Integer.parseInt(st.nextToken()) * 2;

            System.out.println(res);
        }

        br.close();
    }
}
