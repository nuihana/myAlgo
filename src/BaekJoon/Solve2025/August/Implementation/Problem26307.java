package BaekJoon.Solve2025.August.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem26307 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int startH = 9;
        int startM = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        int endH = Integer.parseInt(st.nextToken());
        int endM = Integer.parseInt(st.nextToken());

        System.out.print((endH - startH) * 60 + endM - startM);

        br.close();
    }
}
