package BaekJoon.Solve2025.December.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem17863 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String src = br.readLine();
        if (src.startsWith("555")) System.out.print("YES");
        else System.out.print("NO");

        br.close();
    }
}
