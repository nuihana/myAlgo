package BaekJoon.Solve2025.March.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem10707 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int xLiter = Integer.parseInt(br.readLine());

        int yBase = Integer.parseInt(br.readLine());
        int yLimit = Integer.parseInt(br.readLine());
        int yAdditional = Integer.parseInt(br.readLine());

        int use = Integer.parseInt(br.readLine());

        int x = use * xLiter;
        int y = use > yLimit ? yBase + yAdditional * (use - yLimit) : yBase;

        System.out.print(Math.min(x, y));

        br.close();
    }
}
