package BaekJoon.Solve2023.July.Greedy;

import java.io.*;

public class Problem10610 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();
        int oneCnt = 0;
        int zeroCnt = 0;

        char before = s.charAt(0);
        for (int i = 1; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c != before) {
                if (before == '0') zeroCnt++;
                else oneCnt++;

                before = c;
            }
        }

        if (before == '0') zeroCnt++;
        else oneCnt++;

        bw.write(String.valueOf(Math.min(oneCnt, zeroCnt)));

        br.close();
        bw.close();
    }
}
