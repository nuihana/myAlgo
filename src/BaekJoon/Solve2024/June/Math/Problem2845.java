package BaekJoon.Solve2024.June.Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem2845 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int per = Integer.parseInt(st.nextToken());
        int area = Integer.parseInt(st.nextToken());

        int person = per * area;

        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 5; i++) {
            int now = Integer.parseInt(st.nextToken());

            sb.append(now - person).append(" ");
        }
        System.out.print(sb);

        br.close();
    }
}
