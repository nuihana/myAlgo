package BaekJoon.Solve2025.April.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem27294 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());

        if (t >= 12 && t <= 16 && s ==0) {
            System.out.print(320);
        } else {
            System.out.print(280);
        }

        br.close();
    }
}
