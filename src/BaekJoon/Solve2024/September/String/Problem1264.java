package BaekJoon.Solve2024.September.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem1264 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        while (true) {
            String src = br.readLine();
            if (src.equals("#")) {
                break;
            }

            sb.append(getVowelCnt(src)).append("\n");
        }
        System.out.print(sb);

        br.close();
    }

    private int getVowelCnt(String src) {
        int res = 0;

        for (int i = 0; i < src.length(); i++) {
            char c = src.charAt(i);

            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') res++;
            if (c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U') res++;
        }

        return res;
    }
}
