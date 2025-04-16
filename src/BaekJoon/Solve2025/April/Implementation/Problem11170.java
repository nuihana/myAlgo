package BaekJoon.Solve2025.April.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem11170 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            int res = 0;
            while (n <= m) {
                int tmp = n;
                if (tmp == 0) res++;
                while (tmp > 0) {
                    if (tmp % 10 == 0) res++;
                    tmp /= 10;
                }
                n++;
            }
            sb.append(res).append("\n");
        }
        System.out.print(sb);

        br.close();
    }
}
