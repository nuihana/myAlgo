package BaekJoon.Solve2023.April.Random;

import java.io.*;

public class Problem14470 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int from = Integer.parseInt(br.readLine());
        int to = Integer.parseInt(br.readLine());

        int untilZero = Integer.parseInt(br.readLine());
        int untilPlus = Integer.parseInt(br.readLine());
        int plus = Integer.parseInt(br.readLine());

        int result = 0;

        if (from < 0) {
            result += Math.abs(from) * untilZero;
            result += untilPlus;
            from = 0;
        }

        result += (to - from) * plus;

        bw.write(String.valueOf(result));

        br.close();
        bw.close();
    }
}
