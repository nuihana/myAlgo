package BaekJoon.Solve2023.November.Conte_KUPC;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem30454 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());

        int[] cnts = new int[l + 1];
        for (int i = 0; i < n; i++) {
            String horse = br.readLine();
            int cnt = getPattern(horse);
            cnts[cnt]++;
        }

        for (int i = l; i >= 0; i--) {
            if (cnts[i] > 0) {
                System.out.print(i + " " + cnts[i]);
                break;
            }
        }

        br.close();
    }

    private int getPattern(String str) {
        int res = 0;

        boolean flag = false;
        for (int i = 0; i < str.length(); i++) {
            char now = str.charAt(i);

            if (flag) {
                if (now == '0') {
                    res++;
                    flag = false;
                }
            } else {
                if (now == '1') flag = true;
            }
        }
        if (flag) res++;
        return res;
    }
}
