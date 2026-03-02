package BaekJoon.Solve2026.March.Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem15059 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int aHave = Integer.parseInt(st.nextToken());
        int bHave = Integer.parseInt(st.nextToken());
        int cHave = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int aNeed = Integer.parseInt(st.nextToken());
        int bNeed = Integer.parseInt(st.nextToken());
        int cNeed = Integer.parseInt(st.nextToken());

        System.out.print(Math.max(aNeed - aHave, 0) + Math.max(bNeed - bHave, 0) + Math.max(cNeed - cHave, 0));

        br.close();
    }
}
