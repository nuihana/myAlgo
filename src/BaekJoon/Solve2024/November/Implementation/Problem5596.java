package BaekJoon.Solve2024.November.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem5596 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int aSum = 0;
        while (st.hasMoreTokens()) {
            aSum += Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        int bSum = 0;
        while (st.hasMoreTokens()) {
            bSum += Integer.parseInt(st.nextToken());
        }

        System.out.print(Math.max(aSum, bSum));

        br.close();
    }
}
