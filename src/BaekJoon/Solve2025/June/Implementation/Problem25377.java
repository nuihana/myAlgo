package BaekJoon.Solve2025.June.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem25377 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int res = 1001;
        while (n-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int arrive = Integer.parseInt(st.nextToken());
            int spend = Integer.parseInt(st.nextToken());

            if (arrive <= spend) {
                res = Math.min(res, spend);
            }
        }

        System.out.print(res == 1001 ? -1 : res);

        br.close();
    }
}
