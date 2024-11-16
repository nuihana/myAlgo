package BaekJoon.Solve2024.November.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem1159 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[26];
        for (int i = 0; i < n; i++) {
            String name = br.readLine();

            arr[name.charAt(0) - 'a']++;
        }

        String res = "";
        for (int i = 0; i < 26; i++) {
            if (arr[i] >= 5) {
                res = res.concat(String.valueOf((char) ('a' + i)));
            }
        }

        if (res.isEmpty()) {
            System.out.print("PREDAJA");
        } else {
            System.out.print(res);
        }

        br.close();
    }
}
