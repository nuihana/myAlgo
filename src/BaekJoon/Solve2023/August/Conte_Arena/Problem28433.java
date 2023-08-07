package BaekJoon.Solve2023.August.Conte_Arena;

import java.io.*;
import java.util.StringTokenizer;

public class Problem28433 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int res = 0;
            long sum = 0;
            for (int i = 0; i < n; i++) {
                int a = Integer.parseInt(st.nextToken());

                int condition = 0;
                if (sum > 0) condition++;
                if (a > 0) condition++;
                if (sum + a <= 0) condition++;
                if (condition >= 2) {
                    if (sum > 0) {
                        res++;
                    }
                    if (sum < 0) {
                        res--;
                    }
                    sum = 0;
                }

                sum += a;
            }

            if (sum > 0) {
                res++;
            }
            if (sum < 0) {
                res--;
            }

            if (res > 0) bw.write("YES");
            else bw.write("NO");
            bw.newLine();
        }

        br.close();
        bw.close();
    }
}
