package BaekJoon.Solve2026.April.Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem4435 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            long gArm = 0;

            gArm += Long.parseLong(st.nextToken());
            gArm += Long.parseLong(st.nextToken()) * 2;
            gArm += Long.parseLong(st.nextToken()) * 3;
            gArm += Long.parseLong(st.nextToken()) * 3;
            gArm += Long.parseLong(st.nextToken()) * 4;
            gArm += Long.parseLong(st.nextToken()) * 10;

            st = new StringTokenizer(br.readLine());
            long sArm = 0;

            sArm += Long.parseLong(st.nextToken());
            sArm += Long.parseLong(st.nextToken()) * 2;
            sArm += Long.parseLong(st.nextToken()) * 2;
            sArm += Long.parseLong(st.nextToken()) * 2;
            sArm += Long.parseLong(st.nextToken()) * 3;
            sArm += Long.parseLong(st.nextToken()) * 5;
            sArm += Long.parseLong(st.nextToken()) * 10;

            sb.append("Battle ").append(i).append(": ");
            if (gArm > sArm) {
                sb.append("Good triumphs over Evil").append("\n");
            } else if (gArm < sArm) {
                sb.append("Evil eradicates all trace of Good").append("\n");
            } else {
                sb.append("No victor on this battle field").append("\n");
            }
        }
        System.out.print(sb);

        br.close();
    }
}
