package BaekJoon.Solve2023.June.Random;

import java.io.*;
import java.util.StringTokenizer;

public class Problem10942 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int size = Integer.parseInt(br.readLine());
        int[] seq = new int[size];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < size; i++) {
            seq[i] = Integer.parseInt(st.nextToken());
        }

        int queryCnt = Integer.parseInt(br.readLine());
        for (int i = 0; i < queryCnt; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            a--;
            b--;

            boolean flag = true;
            while (a <= b) {
                if (seq[a] != seq[b]) {
                    flag = false;
                    break;
                }
                a++;
                b--;
            }

            if (flag) {
                bw.write("1");
            } else {
                bw.write("0");
            }
            bw.newLine();
        }

        br.close();
        bw.close();
    }
}
