package BaekJoon.Solve2024.September.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem5554 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int time = 0;
        for (int i = 0; i < 4; i++) {
            time += Integer.parseInt(br.readLine());
        }

        System.out.println(time / 60);
        System.out.print(time % 60);

        br.close();
    }
}
