package BaekJoon.Solve2025.December.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem26068 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int res = 0;
        for (int i = 0; i < n; i++) {
            String src = br.readLine();
            int day = Integer.parseInt(src.substring(2));
            if (day <= 90) res++;
        }
        System.out.print(res);

        br.close();
    }
}
