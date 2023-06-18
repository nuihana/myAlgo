package BaekJoon.Solve2023.June.Conte_SongdoCodeMaster2023;

import java.io.*;
import java.util.*;

public class Problem28238  {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int studentCnt = Integer.parseInt(br.readLine());
        List<Integer> conditions = new ArrayList<>();
        for (int i = 0; i < studentCnt; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int value = 0;
            for (int j = 0; j < 5; j++) {
                int flag = Integer.parseInt(st.nextToken());

                if (flag == 1) {
                    value += (1 << j);
                }
            }

            conditions.add(value);
        }

        int value = 0;
        int[] res = new int[32];
        for (int i = 0; i < 5; i++) {
            value += (1 << i);
            for (int j = i + 1; j < 5; j++) {
                value += (1 << j);

                int cnt = 0;
                for (int bit : conditions) {
                    int temp = 0;
                    for (int k = 0; k < 5; k++) {
                        if ((bit & (1 << k)) > 0 && (value & (1 << k)) > 0) {
                            temp++;
                        }
                    }

                    if (temp == 2) {
                        cnt++;
                    }
                }
                res[value] = cnt;

                value -= (1 << j);
            }
            value -= (1 << i);
        }

        int max = 0;
        int maxBit = 0;
        for (int i = 0; i < 32; i++) {
            if (res[i] > max) {
                max = res[i];
                maxBit = i;
            }
        }

        bw.write(String.valueOf(max));
        bw.newLine();
        if (max > 0) {
            int[] bit = new int[5];
            for (int i = 0; i < 5; i++) {
                if ((maxBit & (1 << i)) > 0) {
                    bit[i] = 1;
                }
            }
            for (int n : bit) {
                bw.write(n + " ");
            }
        } else {
            bw.write("1 1 0 0 0");
        }

        br.close();
        bw.close();
    }
}
