package BaekJoon.Solve2023.March.BasicMath_1;

import java.io.*;
import java.util.*;

public class Problem11005 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int value = Integer.parseInt(st.nextToken());
        int degree = Integer.parseInt(st.nextToken());

        List<Integer> resList = new ArrayList<>();
        while (value > 0) {
            int tmp = value % degree;
            value /= degree;
            resList.add(tmp);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = resList.size() - 1; i >= 0; i--) {
            int tmp = resList.get(i);

            if (tmp < 10) {
                tmp += 48;
            } else {
                tmp += 55;
            }

            sb.append((char) tmp);
        }

        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}
