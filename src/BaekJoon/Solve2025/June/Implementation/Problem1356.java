package BaekJoon.Solve2025.June.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem1356 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String src = br.readLine();
        int[] arr = new int[src.length()];
        for (int i = 0; i < src.length(); i++) {
            arr[i] = src.charAt(i) - '0';
        }

        boolean res = false;
        if (src.length() > 1) {
            for (int i = 1; i < src.length() && !res; i++) {
                int l = 1, r = 1;

                for (int j = 0; j < i; j++) {
                    l *= arr[j];
                }

                for (int j = i; j < src.length(); j++) {
                    r *= arr[j];
                }

                if (l == r) res = true;
            }
        }

        if (res) {
            System.out.print("YES");
        } else {
            System.out.print("NO");
        }

        br.close();
    }
}
