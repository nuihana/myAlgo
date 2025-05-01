package BaekJoon.Solve2025.May.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem1526 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        while (!isKMS(n)) {
            n--;
        }

        System.out.print(n);

        br.close();
    }

    private boolean isKMS(int num) {
        while (num > 0) {
            if (num % 10 != 4 && num % 10 != 7) return false;
            num /= 10;
        }
        return true;
    }
}
