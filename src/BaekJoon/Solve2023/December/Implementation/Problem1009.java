package BaekJoon.Solve2023.December.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem1009 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            int res = 1;
            while (b-- > 0) {
                res *= a;
                res %= 10;
            }


            sb.append(res == 0 ? 10 : res);
            sb.append("\n");
        }

        System.out.print(sb);

        br.close();
    }
}
