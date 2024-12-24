package BaekJoon.Solve2024.December.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem8892 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (tc-- > 0) {
            int k = Integer.parseInt(br.readLine());
            String[] words = new String[k];
            for (int i = 0; i < k; i++) {
                words[i] = br.readLine();
            }

            String res = "0";
            for (int i = 0; i < k; i++) {
                for (int j = 0; j < k; j++) {
                    if (i == j) continue;
                    String tmp = words[i].concat(words[j]);
                    if (isPalindrome(tmp)) {
                        res = tmp;
                    }
                }
            }
            sb.append(res).append("\n");
        }
        System.out.print(sb);

        br.close();
    }

    private boolean isPalindrome(String str) {
        int l = 0, r = str.length() - 1;
        while (l < r) {
            if (str.charAt(l) != str.charAt(r)) return false;
            l++;
            r--;
        }
        return true;
    }
}
