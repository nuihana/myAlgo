package BaekJoon.Solve2025.September.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem1340 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] time = br.readLine().split(" ");

        int year = Integer.parseInt(time[2]);
        boolean yearChk = false;
        if (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)) yearChk = true;

        String month = time[0];
        int intMonth = 0;
        if (month.equals("January")) intMonth = 1;
        else if (month.equals("February")) intMonth = 2;
        else if (month.equals("March")) intMonth = 3;
        else if (month.equals("April")) intMonth = 4;
        else if (month.equals("May")) intMonth = 5;
        else if (month.equals("June")) intMonth = 6;
        else if (month.equals("July")) intMonth = 7;
        else if (month.equals("August")) intMonth = 8;
        else if (month.equals("September")) intMonth = 9;
        else if (month.equals("October")) intMonth = 10;
        else if (month.equals("November")) intMonth = 11;
        else if (month.equals("December")) intMonth = 12;

        int[] days = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
        int day = Integer.parseInt(time[1].split(",")[0]);
        int dayCnt = 0;
        for (int i = 1; i < intMonth; i++) {
            if (yearChk && i == 2) {
                dayCnt += 29;
                continue;
            }
            dayCnt += days[i];
        }
        dayCnt += day;

        int hour = 60 * Integer.parseInt(time[3].split(":")[0]);
        int min = Integer.parseInt(time[3].split(":")[1]);
        int timeHM = hour + min;

        int timeToHour = 60 * 24 * (dayCnt - 1) + timeHM;

        int totalYear = 0;
        if (yearChk) {
            totalYear = 366 * 60 * 24;
        } else {
            totalYear = 365 * 60 * 24;
        }

        System.out.print((double) ((double) timeToHour * 100 / (double) totalYear));

        br.close();
    }
}
