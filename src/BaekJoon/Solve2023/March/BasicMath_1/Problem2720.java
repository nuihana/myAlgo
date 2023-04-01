package BaekJoon.Solve2023.March.BasicMath_1;

import java.io.*;

public class Problem2720 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int testCnt = Integer.parseInt(br.readLine());

        for (int i = 0; i < testCnt; i++) {
            int money = Integer.parseInt(br.readLine());
            StringBuilder sb = new StringBuilder();

            if (money >= 25) {
                int tmp = money / 25;
                money -= tmp * 25;
                sb.append(tmp + " ");
            } else {
                sb.append("0 ");
            }

            if (money >= 10) {
                int tmp = money / 10;
                money -= tmp * 10;
                sb.append(tmp + " ");
            } else {
                sb.append("0 ");
            }

            if (money >= 5) {
                int tmp = money / 5;
                money -= tmp * 5;
                sb.append(tmp + " ");
            } else {
                sb.append("0 ");
            }

            sb.append(money);
            bw.write(sb.toString());
            bw.newLine();
        }

        br.close();
        bw.close();
    }
}
