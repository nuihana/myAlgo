package BaekJoon.Solve2024.November.Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem5532 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int total = Integer.parseInt(br.readLine());

        int aTot = Integer.parseInt(br.readLine());
        int bTot = Integer.parseInt(br.readLine());

        int aDaily = Integer.parseInt(br.readLine());
        int bDaily = Integer.parseInt(br.readLine());

        int aSpend = aTot % aDaily > 0 ? aTot / aDaily + 1 : aTot / aDaily;
        int bSpend = bTot % bDaily > 0 ? bTot / bDaily + 1 : bTot / bDaily;

        System.out.print(total - Math.max(aSpend, bSpend));

        br.close();
    }
}
