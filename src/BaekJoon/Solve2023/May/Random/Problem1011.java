package BaekJoon.Solve2023.May.Random;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem1011 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int testCaseCnt = Integer.parseInt(br.readLine());

        for (int i = 0; i < testCaseCnt; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            int result = 0;
            for (int j = 1; from < to; j++) {
                from += j;
                if (from >= to) {
                    result++;
                    break;
                }

                to -= j;
                result += 2;
            }

            bw.write(String.valueOf(result));
            bw.newLine();
        }

        br.close();
        bw.close();
    }
}
