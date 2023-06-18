package BaekJoon.Solve2023.June.Conte_SongdoCodeMaster2023;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Problem28242 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine());
        List<int[]> left = new ArrayList<>();
        List<int[]> right = new ArrayList<>();

        for (int i = 1, iLimit = (int) Math.sqrt(num); i <= iLimit; i++) {
            if (num % i == 0) {
                int[] div = new int[2];
                div[0] = i;
                div[1] = num / i;
                left.add(div);
                div = new int[2];
                div[0] = -i;
                div[1] = -num / i;
                left.add(div);
            }
        }

        num += 2;
        for (int i = 1, iLimit = (int) Math.sqrt(num); i <= iLimit; i++) {
            if (num % i == 0) {
                int[] div = new int[2];
                div[0] = i;
                div[1] = -num / i;
                right.add(div);
                div = new int[2];
                div[0] = -i;
                div[1] = num / i;
                right.add(div);
            }
        }

        boolean flag = false;
        for (int[] lefts : left) {
            for (int[] rights : right) {
                if (lefts[0] * rights[1] + lefts[1] * rights[0] == num - 1) {
                    bw.write(lefts[0] + " " + rights[0] + " " + lefts[1] + " " + rights[1]);
                    flag = true;
                    break;
                }
            }

            if (flag) {
                break;
            }
        }
        if (!flag) {
            bw.write("-1");
        }

        br.close();
        bw.close();
    }
}
