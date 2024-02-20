package BaekJoon.Solve2024.February.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem2661 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        System.out.print(solve(n, ""));

        br.close();
    }

    private String solve(int len, String str) {
        if (str.length() == len) return str;

        String res = str;
        for (int i = 1; i <= 3; i++) {
            if (possible(str + i) && res.length() < len) res = solve(len, str + i);
        }

        return res;
    }

    private boolean possible(String str) {
        for (int i = 1; i <= str.length() / 2; i++) {
            String front = str.substring(str.length() - i * 2, str.length() - i);
            String back = str.substring(str.length() - i);
            if (front.equals(back)) return false;
        }
        return true;
    }
}
