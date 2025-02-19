package BaekJoon.Solve2025.Feburary.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem5575 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 3; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            System.out.println(getDiff(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        br.close();
    }

    private String getDiff(int sh, int sm, int ss, int eh, int em, int es) {
        int h = eh - sh;

        int m = 0;
        if (em - sm >= 0) {
            m = em - sm;
        } else {
            h--;
            m = em - sm + 60;
        }

        int s = 0;
        if (es - ss >= 0) {
            s = es - ss;
        } else {
            m--;
            if (m < 0) {
                h--;
                m += 60;
            }
            s = es - ss + 60;
        }

        return h + " " + m + " " + s;
    }
}
