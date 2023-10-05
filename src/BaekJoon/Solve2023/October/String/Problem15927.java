package BaekJoon.Solve2023.October.String;

import java.io.*;

public class Problem15927 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String src = br.readLine();
        boolean isPalindrome = true;
        boolean isSameCharacter = true;
        int left = 0;
        int right = src.length() - 1;
        while (left < right) {
            if (src.charAt(left) != src.charAt(right)) {
                isPalindrome = false;
                break;
            }

            if (src.charAt(left) != src.charAt(left + 1)) isSameCharacter = false;
            left++;
            right--;
        }

        if (isPalindrome) {
            if (isSameCharacter) bw.write("-1");
            else bw.write(String.valueOf(src.length() - 1));
        } else {
            bw.write(String.valueOf(src.length()));
        }

        br.close();
        bw.close();
    }
}