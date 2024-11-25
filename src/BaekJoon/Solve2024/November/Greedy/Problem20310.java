package BaekJoon.Solve2024.November.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem20310 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String src = br.readLine();
        int zeroCnt = 0, oneCnt = 0;
        for (int i = 0; i < src.length(); i++) {
            if (src.charAt(i) == '0') zeroCnt++;
            else oneCnt++;
        }

        StringBuilder sb = new StringBuilder();
        oneCnt /= 2;
        for (int i = 0; i < src.length(); i++) { // 앞에서 부터 1 제거
            if (src.charAt(i) == '1' && oneCnt > 0) {
                oneCnt--;
            } else {
                sb.append(src.charAt(i));
            }
        }

        src = sb.toString();
        sb = new StringBuilder();
        zeroCnt /= 2;
        for (int i = src.length() - 1; i >= 0; i--) { // 뒤에서 부터 0 제거
            if (src.charAt(i) == '0' && zeroCnt > 0) {
                zeroCnt--;
            } else {
                sb.append(src.charAt(i));
            }
        }

        System.out.print(sb.reverse());

        br.close();
    }
}
