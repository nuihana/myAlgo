package BaekJoon.Solve2025.July.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem2783 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        double x = Double.parseDouble(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        double res = x / y * 1000;
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            double xi = Double.parseDouble(st.nextToken());
            int yi = Integer.parseInt(st.nextToken());

            double tmp = xi / yi * 1000;
            res = Math.min(res, tmp);
        }
        System.out.print(String.format("%.2f", res));

        br.close();
    }
}
