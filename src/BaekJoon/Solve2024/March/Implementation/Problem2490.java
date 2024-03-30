package BaekJoon.Solve2024.March.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem2490 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] res = { 'E', 'A', 'B', 'C', 'D' };
        for(int i = 0; i < 3; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int cnt = 0;
            for (int j = 0; j < 4; j++) {
                int val = Integer.parseInt(st.nextToken());
                if (val == 0) cnt++;
            }

            System.out.println(res[cnt]);
        }

        br.close();
    }
}
