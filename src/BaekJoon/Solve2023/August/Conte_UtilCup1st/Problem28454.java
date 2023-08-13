package BaekJoon.Solve2023.August.Conte_UtilCup1st;

import java.io.*;

public class Problem28454 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] today = br.readLine().split("-");

        int cnt = Integer.parseInt(br.readLine());
        int res = 0;
        for (int i = 0; i < cnt; i++) {
            String[] expire = br.readLine().split("-");
            if (isValid(today, expire)) res++;
        }

        bw.write(String.valueOf(res));

        br.close();
        bw.close();
    }

    private boolean isValid(String[] now, String[] exp) {
        int now_year = Integer.parseInt(now[0]);
        int exp_year = Integer.parseInt(exp[0]);
        if (now_year > exp_year) return false;
        else if (now_year < exp_year) return true;

        int now_month = Integer.parseInt(now[1]);
        int exp_month = Integer.parseInt(exp[1]);
        if (now_month > exp_month) return false;
        else if (now_month < exp_month) return true;

        int now_day = Integer.parseInt(now[2]);
        int exp_day = Integer.parseInt(exp[2]);
        if (now_day > exp_day) return false;
        else if (now_day < exp_day) return true;

        return true;
    }
}
