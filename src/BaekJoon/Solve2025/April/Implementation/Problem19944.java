package BaekJoon.Solve2025.April.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem19944 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        if (m == 1 || m == 2) {
            System.out.print("NEWBIE!");
        } else if (m <= n) {
            System.out.print("OLDBIE!");
        } else {
            System.out.print("TLE!");
        }

        br.close();
    }
}
