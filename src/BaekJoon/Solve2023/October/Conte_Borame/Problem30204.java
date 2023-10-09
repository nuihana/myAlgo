package BaekJoon.Solve2023.October.Conte_Borame;

import java.io.*;
import java.util.StringTokenizer;

public class Problem30204 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int total = 0;
        while (st.hasMoreTokens()) {
            total += Integer.parseInt(st.nextToken());
        }

        if (total % x == 0) bw.write("1");
        else bw.write("0");

        br.close();
        bw.close();
    }
}
