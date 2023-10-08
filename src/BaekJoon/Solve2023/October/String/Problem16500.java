package BaekJoon.Solve2023.October.String;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Problem16500 {

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String src = br.readLine();
        int n = Integer.parseInt(br.readLine());
        List<String> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            list.add(br.readLine());
        }

        boolean[] dp = new boolean[101];
        for (int i = 0; i < src.length(); i++) {
            if (dp[i] || i == 0) {
                int start = i;
                for (int j = 0; j < n; j++) {
                    if (start + list.get(j).length() > src.length()) continue;

                    boolean flag = true;
                    for (int k = 0; k < list.get(j).length(); k++) {
                        if (list.get(j).charAt(k) != src.charAt(start + k)) {
                            flag = false;
                            break;
                        }
                    }

                    if (flag) {
                        dp[start + list.get(j).length()] = true;
                    }
                }
            }
        }

        if (dp[src.length()]) bw.write("1");
        else bw.write("0");

        br.close();
        bw.close();
    }
}
