package BaekJoon.Solve2023.March.Repeater;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem25314 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int byteVal = Integer.parseInt(br.readLine());
        byteVal = byteVal / 4;

        for (int i = 0; i < byteVal; i++) {
            System.out.print("long ");
        }
        System.out.print("int");

        br.close();
    }
}
