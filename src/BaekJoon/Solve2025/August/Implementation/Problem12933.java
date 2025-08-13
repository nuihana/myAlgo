package BaekJoon.Solve2025.August.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem12933 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String src = br.readLine();
        int res = 0;
        boolean[] isChk = new boolean[src.length()];
        int remain = src.length();
        while (remain > 0) {
            int chk = searchDuck(src, isChk);
            remain -= chk;

            if (chk > 0) res++;
            else break;
        }
        System.out.print(remain == 0 ? res : -1);

        br.close();
    }

    private int searchDuck(String src, boolean[] isChecked) {
        char[] duck = { 'q', 'u', 'a', 'c', 'k' };
        int idx = 0;
        int chk = 0;
        for (int i = 0; i < src.length(); i++) {
            if (src.charAt(i) == duck[idx] && !isChecked[i]) {
                isChecked[i] = true;
                idx++;
                if (idx == 5) {
                    idx = 0;
                    chk += 5;
                }
            }
        }

        return chk;
    }
}
