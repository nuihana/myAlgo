package BaekJoon.Solve2025.Feburary.Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem1225 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        long res = 0;

        char[] a = st.nextToken().toCharArray();
        char[] b = st.nextToken().toCharArray();
        for (char ac : a) {
            for (char bc : b) {
                res += (ac - '0') * (bc - '0');
            }
        }
        System.out.print(res);

        br.close();
    }
}
