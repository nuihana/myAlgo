package BaekJoon.Solve2024.April.Recursive;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Problem1914 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int cnt = Integer.parseInt(br.readLine());

        BigInteger res = new BigInteger("2");
        System.out.println(res.pow(cnt).subtract(new BigInteger("1")));

        if (cnt <= 20) {
            StringBuilder sb = new StringBuilder();
            move(cnt, 1, 3, 2, sb);
            System.out.print(sb);
        }

        br.close();
    }

    private void move(int height, int from, int to, int sub, StringBuilder sb) {
        if (height == 1) {
            sb.append(from).append(" ").append(to).append("\n");
            return;
        }

        move(height - 1, from, sub, to, sb);
        sb.append(from).append(" ").append(to).append("\n");
        move(height - 1, sub, to, from, sb);
    }
}
