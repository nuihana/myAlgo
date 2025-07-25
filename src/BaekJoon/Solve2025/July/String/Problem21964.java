package BaekJoon.Solve2025.July.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem21964 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String src = br.readLine();
        System.out.print(src.substring(n - 5, n));

        br.close();
    }
}
