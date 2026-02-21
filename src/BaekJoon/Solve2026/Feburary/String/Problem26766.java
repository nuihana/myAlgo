package BaekJoon.Solve2026.Feburary.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem26766 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (n-- > 0) {
            sb.append(" @@@   @@@ \n");
            sb.append("@   @ @   @\n");
            sb.append("@    @    @\n");
            sb.append("@         @\n");
            sb.append(" @       @ \n");
            sb.append("  @     @  \n");
            sb.append("   @   @   \n");
            sb.append("    @ @    \n");
            sb.append("     @     \n");
        }
        System.out.print(sb);

        br.close();
    }
}
