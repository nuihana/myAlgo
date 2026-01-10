package BaekJoon.Solve2026.January.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem6763 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int limit = Integer.parseInt(br.readLine());
        int speed = Integer.parseInt(br.readLine());
        if (speed <= limit) {
            System.out.print("Congratulations, you are within the speed limit!");
        } else if (speed <= limit + 20) {
            System.out.print("You are speeding and your fine is $100.");
        } else if (speed <= limit + 30) {
            System.out.print("You are speeding and your fine is $270.");
        } else {
            System.out.print("You are speeding and your fine is $500.");
        }

        br.close();
    }
}
