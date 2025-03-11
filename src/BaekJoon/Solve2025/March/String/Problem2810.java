package BaekJoon.Solve2025.March.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem2810 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String seat = br.readLine();

        int holderCnt = 1;
        int clientCnt = 0;

        for (int i = 0; i < n; i++) {
            char c = seat.charAt(i);

            if (c == 'L') {
                clientCnt++;
                i++;
            }
            clientCnt++;
            holderCnt++;
        }

        System.out.print(Math.min(holderCnt, clientCnt));

        br.close();
    }
}
