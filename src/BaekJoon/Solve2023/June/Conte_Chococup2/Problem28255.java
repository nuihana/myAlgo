package BaekJoon.Solve2023.June.Conte_Chococup2;

import java.io.*;
import java.util.*;

public class Problem28255 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int cnt = Integer.parseInt(br.readLine());
        for (int ca = 0; ca < cnt; ca++) {
            String str = br.readLine();

            int len = (int) Math.ceil((double) str.length() / 3);

            String head = str.substring(0, len);

            String data = head.concat(rev(head)).concat(head);
            String result = "0";
            if (str.equals(data)) {
                result = "1";
            }
            data = head.concat(tail(rev(head))).concat(head);
            if (str.equals(data)) {
                result = "1";
            }
            data = head.concat(rev(head)).concat(tail(head));
            if (str.equals(data)) {
                result = "1";
            }
            data = head.concat(tail(rev(head))).concat(tail(head));
            if (str.equals(data)) {
                result = "1";
            }
            bw.write(result);
            bw.newLine();
        }

        br.close();
        bw.close();
    }

    private String rev(String str) {
        StringBuilder sb = new StringBuilder(str);
        sb.reverse();
        return sb.toString();
    }

    private String tail(String str) {
        return str.substring(1, str.length());
    }
}
