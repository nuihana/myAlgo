package BaekJoon.NumberAndCombinatorics;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem1037 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int cnt = Integer.parseInt(br.readLine());
        int[] divisorArr = new int[cnt];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < cnt; i++) {
            divisorArr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(divisorArr);

        if (cnt == 1) {
            bw.write(Integer.toString(divisorArr[0] * divisorArr[0]));
        } else {
            bw.write(Integer.toString(divisorArr[0] * divisorArr[cnt - 1]));
        }

        bw.close();
        br.close();
    }
}
