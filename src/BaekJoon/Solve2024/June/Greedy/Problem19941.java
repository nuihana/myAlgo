package BaekJoon.Solve2024.June.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Problem19941 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int len = Integer.parseInt(st.nextToken());
        int dist = Integer.parseInt(st.nextToken());

        int res = 0;
        String table = br.readLine();
        boolean[] isEaten = new boolean[len];
        for (int i = 0; i < len; i++) {
            char c = table.charAt(i);

            if (c == 'P') {
                for (int j = i - dist; j <= i + dist; j++) {
                    if (j >= 0 && j < len && table.charAt(j) == 'H' && !isEaten[j]) {
                        isEaten[j] = true;
                        res++;
                        break;
                    }
                }
            }
        }

        System.out.print(res);

        br.close();
    }
}
