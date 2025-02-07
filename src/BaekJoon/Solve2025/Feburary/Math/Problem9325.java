package BaekJoon.Solve2025.Feburary.Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem9325 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (tc-- > 0) {
            int price = Integer.parseInt(br.readLine());
            int optCnt = Integer.parseInt(br.readLine());
            for (int i = 0; i < optCnt; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int cnt = Integer.parseInt(st.nextToken());
                int worth = Integer.parseInt(st.nextToken());

                price += cnt * worth;
            }

            sb.append(price).append("\n");
        }
        System.out.print(sb);

        br.close();
    }
}
