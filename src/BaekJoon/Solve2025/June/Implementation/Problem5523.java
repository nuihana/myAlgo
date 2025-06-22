package BaekJoon.Solve2025.June.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem5523 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int a = 0, b = 0;
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int as = Integer.parseInt(st.nextToken());
            int bs = Integer.parseInt(st.nextToken());

            if (as > bs) a++;
            else if (as < bs) b++;
        }
        System.out.print(a + " " + b);

        br.close();
    }
}
