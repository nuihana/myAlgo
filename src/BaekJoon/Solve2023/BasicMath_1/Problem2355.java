package BaekJoon.Solve2023.BasicMath_1;

import java.io.*;
import java.util.StringTokenizer;

public class Problem2355 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        long from = Integer.parseInt(st.nextToken());
        long to = Integer.parseInt(st.nextToken());

        long maxi = Math.max(from, to);
        long mini = Math.min(from, to);

        long result = 0;
        result = (from + to) * ((maxi - (mini - 1)) / 2);
        if ((maxi - (mini - 1)) % 2 != 0) {
            result += (from + to) / 2;
        }

        bw.write(String.valueOf(result));

        br.close();
        bw.close();
    }
}
