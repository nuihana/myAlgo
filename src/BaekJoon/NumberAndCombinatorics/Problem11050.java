package BaekJoon.NumberAndCombinatorics;

import java.io.*;
import java.util.StringTokenizer;

public class Problem11050 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int result = factorial(a) / (factorial(a - b) * factorial(b));

        bw.write(Integer.toString(result));

        bw.close();
        br.close();
    }

    private int factorial(int value) {
        if (value <= 1) {
            return 1;
        }

        int result = 1;

        result *= value;
        result *= factorial(value - 1);

        return result;
    }
}
