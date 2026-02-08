package BaekJoon.Solve2026.Feburary.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem7572 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        n = (n + 56) % 60;

        int[] pre = new int[10];
        for (int i = 0; i < 10; i++) pre[i] = i;

        char[] aft = new char[12];
        for (int i = 0; i < 12; i++) aft[i] = (char) ('A' + i);

        System.out.print(aft[n % 12] + "" + pre[n % 10]);

        br.close();
    }
}
