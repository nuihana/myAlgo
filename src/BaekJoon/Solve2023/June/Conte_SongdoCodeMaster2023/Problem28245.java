package BaekJoon.Solve2023.June.Conte_SongdoCodeMaster2023;

import java.io.*;

public class Problem28245 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int menuCnt = Integer.parseInt(br.readLine());

        for (int i = 0; i < menuCnt; i++) {
            long num = Long.parseLong(br.readLine());

            long value = 0;
            boolean flag = false;
            long dif = Long.MAX_VALUE;
            int[] point = new int[2];
            for (int j = 0; j < 61; j++) {
                value += (1L << j);
                for (int k = j; k < 61; k++) {
                    value += (1L << k);

                    if (num == value) {
                        bw.write(j + " " + k);
                        bw.newLine();
                        flag = true;
                        break;
                    } else if (Math.abs(num - value) < dif){
                        dif = Math.abs(num - value);
                        point[0] = j;
                        point[1] = k;
                    }

                    value -= (1L << k);
                }
                if (flag) {
                    break;
                }
                value -= (1L << j);
            }

            if (!flag) {
                bw.write(point[0] + " " + point[1]);
                bw.newLine();
            }
        }

        br.close();
        bw.close();
    }
}
