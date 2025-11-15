package BaekJoon.Solve2025.November.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem18409 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String src = br.readLine();

        int cnt = 0;
        for (int i = 0; i < n; i++) {
            char c = src.charAt(i);
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                cnt++;
            }
        }
        System.out.print(cnt);

        br.close();
    }
}
