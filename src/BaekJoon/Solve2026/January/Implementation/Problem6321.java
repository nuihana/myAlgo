package BaekJoon.Solve2026.January.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem6321 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        int idx = 1;
        while (n-- > 0) {
            String src = br.readLine();

            sb.append("String #" + idx++ + "\n");
            for (int i = 0; i < src.length(); i++) {
                char c = src.charAt(i) == 'Z' ? 'A' : (char) (src.charAt(i) + 1);
                sb.append(c);
            }
            sb.append("\n\n");
        }
        System.out.print(sb);

        br.close();
    }
}
