package BaekJoon.Solve2024.January.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem1924 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int month = Integer.parseInt(st.nextToken());
        int day = Integer.parseInt(st.nextToken());

        int[] monthlyDay = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

        int totalDay = 0;
        for (int i = 0; i < month; i++) {
            totalDay += monthlyDay[i];
        }
        totalDay += day - 1;

        String[] week = { "SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT" };
        System.out.print(week[totalDay % 7]);

        br.close();
    }
}
