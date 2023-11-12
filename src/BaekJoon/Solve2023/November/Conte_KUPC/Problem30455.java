package BaekJoon.Solve2023.November.Conte_KUPC;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem30455 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        if (n % 2 == 0) System.out.print("Duck");
        else System.out.print("Goose");

        br.close();
    }
}
