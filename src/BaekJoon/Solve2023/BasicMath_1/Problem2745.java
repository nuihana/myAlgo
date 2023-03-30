package BaekJoon.Solve2023.BasicMath_1;

import java.io.*;
import java.util.StringTokenizer;

public class Problem2745 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        String value = st.nextToken();
        int degree = Integer.parseInt(st.nextToken());

        long result = 0;
        for (int i = 0; i < value.length(); i++) {
            int tmp = value.charAt(i);
            if (tmp < 65) {
                tmp -= 48;
            } else {
                tmp -= 55;
            }

            result += Math.pow(degree, value.length() - 1 - i) * tmp;
        }

        bw.write(String.valueOf(result));

        br.close();
        bw.close();
    }
}
