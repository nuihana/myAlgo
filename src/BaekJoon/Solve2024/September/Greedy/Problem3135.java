package BaekJoon.Solve2024.September.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem3135 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int chCnt = Integer.parseInt(br.readLine());
        int min = Math.abs(b - a);
        for (int i = 0; i < chCnt; i++) {
            int ch = Integer.parseInt(br.readLine());
            min = Math.min(min, Math.abs(b - ch) + 1);
        }
        System.out.print(min);

        br.close();
    }
}
