package BaekJoon.Solve2025.January.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem10768 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int month = Integer.parseInt(br.readLine());
        int day = Integer.parseInt(br.readLine());

        if (month < 2) {
            System.out.print("Before");
        } else if (month == 2) {
            if (day < 18) {
                System.out.print("Before");
            } else if (day == 18) {
                System.out.print("Special");
            } else {
                System.out.print("After");
            }
        } else {
            System.out.print("After");
        }

        br.close();
    }
}
