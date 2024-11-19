package BaekJoon.Solve2024.November.Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Problem11068 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            int input = Integer.parseInt(br.readLine());

            if (chk(input)) {
                sb.append("1");
            } else {
                sb.append("0");
            }
            sb.append("\n");
        }
        System.out.print(sb);

        br.close();
    }

    private boolean chk(int val) {
        for (int i = 2; i <= 64; i++) {
            List<Integer> list = new ArrayList<>();
            int tmp = val;

            while (tmp > 0) {
                list.add(tmp % i);
                tmp /= i;
            }

            if (isPalindrome(list)) return true;
        }
        return false;
    }

    private boolean isPalindrome(List<Integer> val) {
        int l = 0;
        int r = val.size() - 1;
        while (l < r) {
            if (val.get(l) != val.get(r)) return false;
            l++;
            r--;
        }
        return true;
    }
}
