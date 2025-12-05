package BaekJoon.Solve2025.December.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem18917 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int m = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        long sum = 0, xor = 0;
        while (m-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int q = Integer.parseInt(st.nextToken());

            if (q == 1 || q == 2) {
                int val = Integer.parseInt(st.nextToken());

                if (q == 1) {
                    sum += val;
                    xor ^= val;
                } else {
                    sum -= val;
                    xor ^= val;
                }
            } else if (q == 3) {
                sb.append(sum).append("\n");
            } else if (q == 4) {
                sb.append(xor).append("\n");
            }
        }
        System.out.print(sb);

        br.close();
    }
}
