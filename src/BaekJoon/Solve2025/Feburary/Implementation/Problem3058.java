package BaekJoon.Solve2025.Feburary.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem3058 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (tc-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int min = Integer.MAX_VALUE;
            int sum = 0;
            while (st.hasMoreTokens()) {
                int num = Integer.parseInt(st.nextToken());

                if (num % 2 == 0) {
                    sum += num;
                    min = Math.min(min, num);
                }
            }

            sb.append(sum).append(" ").append(min).append("\n");
        }
        System.out.print(sb);

        br.close();
    }
}
