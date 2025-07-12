package BaekJoon.Solve2025.July.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem3062 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            String src = br.readLine();
            int asc = Integer.parseInt(src);

            StringBuilder conv = new StringBuilder();
            for (int i = src.length() - 1; i >= 0; i--) {
                conv.append(src.charAt(i));
            }
            int desc = Integer.parseInt(conv.toString());

            String res = String.valueOf(asc + desc);
            conv = new StringBuilder();
            for (int i = res.length() - 1; i >= 0; i--) {
                conv.append(res.charAt(i));
            }
            String resRev = conv.toString();

            boolean isOk = true;
            for (int i = 0; i < res.length(); i++) {
                if (res.charAt(i) != resRev.charAt(i)) {
                    isOk = false;
                    break;
                }
            }

            if (isOk) {
                sb.append("YES\n");
            } else {
                sb.append("NO\n");
            }
        }
        System.out.print(sb);

        br.close();
    }
}
