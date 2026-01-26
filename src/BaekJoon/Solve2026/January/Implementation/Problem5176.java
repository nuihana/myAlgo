package BaekJoon.Solve2026.January.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem5176 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            boolean[] isFilled = new boolean[m + 1];
            int res = 0;
            for (int i = 0; i < p; i++) {
                int seat = Integer.parseInt(br.readLine());
                if (isFilled[seat]) res++;
                else isFilled[seat] = true;
            }
            sb.append(res).append("\n");
        }
        System.out.print(sb);

        br.close();
    }
}
