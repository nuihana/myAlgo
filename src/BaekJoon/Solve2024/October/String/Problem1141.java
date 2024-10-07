package BaekJoon.Solve2024.October.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Problem1141 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        List<String> strList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            strList.add(br.readLine());
        }

        strList.sort((s1, s2) -> s1.length() - s2.length());

        int partCnt = 0;
        for (int i = 0; i < strList.size(); i++) {
            String tmp = strList.get(i);
            for (int j = i + 1; j < strList.size(); j++) {
                if (isStartWith(strList.get(j), tmp)) {
                    partCnt++;
                    break;
                }
            }
        }

        System.out.print(n - partCnt);

        br.close();
    }

    private boolean isStartWith(String src, String cpr) {
        for (int i = 0; i < cpr.length(); i++) {
            if (src.charAt(i) != cpr.charAt(i)) return false;
        }
        return true;
    }
}
