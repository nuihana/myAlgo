package BaekJoon.Solve2025.October.Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem17009 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int a = 0;
        a += Integer.parseInt(br.readLine()) * 3;
        a += Integer.parseInt(br.readLine()) * 2;
        a += Integer.parseInt(br.readLine());

        int b = 0;
        b += Integer.parseInt(br.readLine()) * 3;
        b += Integer.parseInt(br.readLine()) * 2;
        b += Integer.parseInt(br.readLine());

        if (a > b) {
            System.out.print("A");
        } else if (a < b) {
            System.out.print("B");
        } else {
            System.out.print("T");
        }

        br.close();
    }
}
