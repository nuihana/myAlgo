package BaekJoon.Solve2023.September.String;

import java.io.*;

public class Problem17609 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String str = br.readLine();

            bw.write(String.valueOf(chkPalindrome(str, 0, str.length() - 1, 0)));
            bw.newLine();
        }

        br.close();
        bw.close();
    }

    private int chkPalindrome(String str, int l, int r, int n) {
        if (n > 1) return 2;
        if (l >= r) return n;

        if (str.charAt(l) == str.charAt(r)) {
            return chkPalindrome(str, l + 1, r - 1, n);
        } else {
            int left = chkPalindrome(str, l + 1, r, n + 1);
            if (left == 2) {
                return chkPalindrome(str, l, r - 1, n + 1);
            } else {
                return left;
            }
        }
    }
}
