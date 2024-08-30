package BaekJoon.Solve2024.August.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem4999 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int pCnt = getACnt(br.readLine());
        int nCnt = getACnt(br.readLine());
        if (pCnt >= nCnt) {
            System.out.print("go");
        } else {
            System.out.print("no");
        }

        br.close();
    }

    private int getACnt(String src) {
        int res = 0;
        for (int i = 0; i < src.length(); i++) {
            if (src.charAt(i) == 'a') res++;
        }
        return res;
    }
}
