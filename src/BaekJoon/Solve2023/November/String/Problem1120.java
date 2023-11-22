package BaekJoon.Solve2023.November.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem1120 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        String cpr = st.nextToken();
        String src = st.nextToken();

        int minDiff = Integer.MAX_VALUE;
        for (int i = 0; i < src.length() - cpr.length(); i++) {
            int diff = 0;
            for (int j = 0; j < cpr.length(); j++) {
                if (cpr.charAt(j) != src.charAt(i + j)) {
                    diff++;
                }
            }

            minDiff = Math.min(minDiff, diff);
        }

        System.out.print(minDiff);

        br.close();
    }
}
