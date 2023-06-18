package BaekJoon.Solve2023.June.Conte_SongdoCodeMaster2023;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Problem28239 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int menuCnt = Integer.parseInt(br.readLine());

        for (int i = 0; i < menuCnt; i++) {
            long num = Long.parseLong(br.readLine());

            long value = 0;
            boolean flag = false;
            for (int j = 0; j < 61; j++) {
                value += (1L << j);
                for (int k = j; k < 61; k++) {
                    value += (1L << k);

                    if (num == value) {
                        bw.write(j + " " + k);
                        bw.newLine();
                        flag = true;
                        break;
                    }

                    value -= (1L << k);
                }
                if (flag) {
                    break;
                }
                value -= (1L << j);
            }
        }

        br.close();
        bw.close();
    }
}
