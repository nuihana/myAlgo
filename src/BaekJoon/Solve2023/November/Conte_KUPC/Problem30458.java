package BaekJoon.Solve2023.November.Conte_KUPC;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem30458 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String src = br.readLine();

        int[] alpha = new int[26];

        int half = n / 2;
        for (int i = 0; i < half; i++) {
            alpha[src.charAt(i) - 'a']++;
        }

        if (n % 2 == 1) half++;
        for (int i = half; i < n; i++) {
            alpha[src.charAt(i) - 'a']++;
        }

        boolean flag = true;
        for (int i = 0; i < 26; i++) {
            if (alpha[i] % 2 != 0) {
                flag = false;
                break;
            }
        }

        if (flag) System.out.print("Yes");
        else System.out.print("No");

        br.close();
    }
}
