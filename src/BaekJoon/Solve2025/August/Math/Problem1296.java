package BaekJoon.Solve2025.August.Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Problem1296 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String name = br.readLine();

        int n = Integer.parseInt(br.readLine());
        String[] teams = new String[n];
        for (int i = 0; i < n; i++) {
            teams[i] = br.readLine();
        }

        Arrays.sort(teams);

        int max = -1;
        String res = "";
        for (int i = 0; i < n; i++) {
            int score = score(name, teams[i]);
            if (score > max) {
                max = score;
                res = teams[i];
            }
        }
        System.out.print(res);

        br.close();
    }

    private int score(String name, String team) {
        final int MOD = 100;

        int l = 0, o = 0, v = 0, e = 0;

        for (int i = 0; i < name.length(); i++) {
            char c = name.charAt(i);
            if (c == 'L') l++;
            if (c == 'O') o++;
            if (c == 'V') v++;
            if (c == 'E') e++;
        }

        for (int i = 0; i < team.length(); i++) {
            char c = team.charAt(i);
            if (c == 'L') l++;
            if (c == 'O') o++;
            if (c == 'V') v++;
            if (c == 'E') e++;
        }

        int res = ((l + o) * (l + v) * (l + e) * (o + v) * (o + e) * (v + e)) % MOD;
        return res;
    }
}
