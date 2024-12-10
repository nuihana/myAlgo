package BaekJoon.Solve2024.December.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem12871 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        String t = br.readLine();

        String fs = s.concat("");
        String ft = t.concat("");

        while (fs.length() != ft.length()) {
            if (fs.length() < ft.length()) {
                fs = fs.concat(s);
            } else {
                ft = ft.concat(t);
            }
        }

        int pivot = 0;
        int res = 1;
        for (int i = 0; i < ft.length() && res == 1; i++) {
            if (ft.charAt(i) == fs.charAt(pivot)) {
                pivot++;
            } else {
                res = 0;
            }

            if (pivot == fs.length()) pivot = 0;
        }

        System.out.print(res);

        br.close();
    }
}
