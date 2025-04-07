package BaekJoon.Solve2025.April.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem4504 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (true) {
            int num = Integer.parseInt(br.readLine());
            if (num == 0) break;

            if (num % n == 0) {
                sb.append(num).append(" is a multiple of ").append(n).append(".\n");
            } else {
                sb.append(num).append(" is NOT a multiple of ").append(n).append(".\n");
            }
        }
        System.out.print(sb);

        br.close();
    }
}
