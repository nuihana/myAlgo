package BaekJoon.Solve2025.December.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem13410 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int max = -1;
        for (int i = 1; i <= k; i++) {
            int val = n * i;

            int convert = convert(val);
            max = Math.max(max, convert);
        }
        System.out.print(max);

        br.close();
    }

    private int convert(int val) {
        int res = 0, nth = 1;
        while (val > 0) {
            res += (val % 10) * nth;
            val /= 10;
            nth *= 10;
        }
        return res;
    }
}
