package BaekJoon.Solve2026.Feburary.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem13567 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int len = Integer.parseInt(st.nextToken());
        int query = Integer.parseInt(st.nextToken());

        int x = 0, y = 0, dir = 1;
        int[] dx = { 0, 1, 0, -1 };
        int[] dy = { 1, 0, -1, 0 };
        boolean isOut = false;
        while (query-- > 0 && !isOut) {
            st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();
            int val = Integer.parseInt(st.nextToken());

            if (cmd.equals("MOVE")) {
                x = x + dx[dir] * val;
                y = y + dy[dir] * val;
            } else if (cmd.equals("TURN")) {
                if (val == 0) dir = (dir + 3) % 4;
                else if (val == 1) dir = (dir + 1) % 4;
            }

            if (x < 0 || x >= len || y < 0 || y >= len) isOut = true;
        }

        if (isOut) System.out.print(-1);
        else System.out.print(x + " " + y);

        br.close();
    }
}
