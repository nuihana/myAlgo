package BaekJoon.Solve2023.October.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Problem3107 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String ip = br.readLine();
        if (ip.contains("::")) {
            ip = ip.replace("::", ":g:");
        }
        String[] ips = ip.split(":");
        List<String> res = new ArrayList<>();

        for (String part : ips) {
            if (part.isEmpty()) continue;
            res.add(lpad(part));
        }

        int groupLen = 8 - res.size() + 1;
        String[] fullIp = new String[8];
        int idx = 0;
        for (String part : res) {
            if (part.equals("group")) {
                while (groupLen-- > 0) {
                    fullIp[idx++] = "0000";
                }
            } else {
                fullIp[idx++] = part;
            }
        }

        System.out.println(String.join(":", fullIp));

        br.close();
    }

    private String lpad(String src) {
        if (src.length() >= 4) return src;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < Math.max(0, 4 - src.length()); i++) {
            sb.append("0");
        }
        sb.append(src);
        return sb.toString();
    }
}
