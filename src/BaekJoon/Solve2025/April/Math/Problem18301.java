package BaekJoon.Solve2025.April.Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem18301 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n1 = Integer.parseInt(st.nextToken());
        int n2 = Integer.parseInt(st.nextToken());
        int n12 = Integer.parseInt(st.nextToken());

        System.out.print((int) Math.ceil((n1 + 1) * (n2 + 1) / (n12 + 1)  -1));

        br.close();
    }
}
