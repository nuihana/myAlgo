package BaekJoon.Solve2023.August.Random;

import java.io.*;
import java.util.StringTokenizer;

public class Problem2022 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        double x = Double.parseDouble(st.nextToken());
        double y = Double.parseDouble(st.nextToken());
        double c = Double.parseDouble(st.nextToken());

        double high = Math.max(x, y);
        double low = 1;
        double ans = 0;

        while(low <= high) {
            low += 0.001;

            double w = (low + high) / 2;
            double h1 = Math.sqrt(Math.pow(x, 2) - Math.pow(w, 2));
            double h2 = Math.sqrt(Math.pow(y, 2) - Math.pow(w, 2));

            double now = (h1 * h2) / (h1 + h2);
            if (now >= c) {
                ans = w;
                low = w;
            } else {
                high = w;
            }
        }

        bw.write(String.valueOf(ans));

        br.close();
        bw.close();
    }
}
