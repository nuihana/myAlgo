package BaekJoon.Solve2025.June.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem16199 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int birthYear = Integer.parseInt(st.nextToken());
        int birthMonth = Integer.parseInt(st.nextToken());
        int birthDay = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int nowYear = Integer.parseInt(st.nextToken());
        int nowMonth = Integer.parseInt(st.nextToken());
        int nowDay = Integer.parseInt(st.nextToken());

        int man = nowYear - birthYear - 1;
        if (nowMonth > birthMonth || nowMonth == birthMonth && nowDay >= birthDay) man++;

        int se = nowYear - birthYear + 1;
        int yun = nowYear - birthYear;

        System.out.println(man);
        System.out.println(se);
        System.out.print(yun);

        br.close();
    }
}
