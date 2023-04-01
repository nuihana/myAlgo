package BaekJoon.Solve2023.March.Advanced_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem10988 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        int begin = 0;
        int end = str.length() - 1;

        boolean flag = true;

        while (begin < end) {
            if (str.charAt(begin) != str.charAt(end)) {
                System.out.print("0");
                flag = false;
                break;
            }
            begin++;
            end--;
        }

        if (flag) {
            System.out.print("1");
        }

        br.close();
    }
}
