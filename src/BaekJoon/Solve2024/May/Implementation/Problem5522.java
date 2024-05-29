package BaekJoon.Solve2024.May.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem5522 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int sum = 0;
        while (true) {
            String input = br.readLine();

            if (input == null) break;

            sum += Integer.parseInt(input);
        }

        System.out.print(sum);

        br.close();
    }
}
