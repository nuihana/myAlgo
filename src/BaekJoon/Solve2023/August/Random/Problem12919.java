package BaekJoon.Solve2023.August.Random;

import java.io.*;

public class Problem12919 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String origin = br.readLine();
        String target = br.readLine();

        if (isPossible(origin, target)) bw.write("1");
        else bw.write("0");

        br.close();
        bw.close();
    }

    private boolean isPossible(String src, String des) {
        if (src.length() == des.length()) {
            return src.equals(des);
        }

        boolean res = false;
        if (des.charAt(des.length() - 1) == 'A') {
            res = isPossible(src, des.substring(0, des.length() - 1));
        }

        if (!res && des.charAt(0) == 'B') {
            StringBuilder sb = new StringBuilder(des.substring(1));
            res = isPossible(src, sb.reverse().toString());
        }

        return res;
    }
}
