package BaekJoon.Solve2026.January.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.StringTokenizer;

public class Problem17521 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int day = Integer.parseInt(st.nextToken());
        long money = Integer.parseInt(st.nextToken());

        long amount = 0;
        int now = Integer.parseInt(br.readLine());
        for (int i = 1; i < day; i++) {
            int tomorrow = Integer.parseInt(br.readLine());
            if (now < tomorrow) {
                amount += money / now;
                money %= now;
            } else if (now > tomorrow) {
                money += amount * now;
                amount = 0;
            }

            now = tomorrow;
        }

        if (amount > 0) money += amount * now;
        System.out.print(money);

        br.close();
    }
}
