package BaekJoon.Solve2024.December.Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem10833 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int res = 0;
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int stu = Integer.parseInt(st.nextToken());
            int app = Integer.parseInt(st.nextToken());

            res += app % stu;
        }
        System.out.println(res);

        br.close();
    }
}
