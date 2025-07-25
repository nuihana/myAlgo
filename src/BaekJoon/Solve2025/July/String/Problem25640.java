package BaekJoon.Solve2025.July.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem25640 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String mbti = br.readLine();
        int n = Integer.parseInt(mbti);
        int res = 0;
        for (int i = 0; i < n; i++) {
            String cpr = br.readLine();
            if (mbti.equals(cpr)) res++;
        }
        System.out.print(res);

        br.close();
    }
}
