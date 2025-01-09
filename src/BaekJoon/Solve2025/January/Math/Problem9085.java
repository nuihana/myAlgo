package BaekJoon.Solve2025.January.Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem9085 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (tc-- > 0) {
            int t = Integer.parseInt(br.readLine());
            int res = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < t; i++) {
                int num = Integer.parseInt(st.nextToken());
                if (num <= 10) res += num;
            }
            sb.append(res).append("\n");
        }
        System.out.print(sb);

        br.close();
    }
}
