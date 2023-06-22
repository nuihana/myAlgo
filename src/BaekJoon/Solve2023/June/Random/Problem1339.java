package BaekJoon.Solve2023.June.Random;

import java.io.*;
import java.util.Arrays;
import java.util.Collections;

public class Problem1339 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int cnt = Integer.parseInt(br.readLine());
        Integer[] customMap = new Integer[26];
        for (int i = 0; i < 26; i++) {
            customMap[i] = 0;
        }

        for (int i = 0; i < cnt; i++) {
            String str = br.readLine();

            for (int j = 0; j < str.length(); j++) {
                char c = str.charAt(j);

                customMap[c - 65] += (int) Math.pow(10, str.length() - 1 - j);
            }
        }

        Arrays.sort(customMap, Collections.reverseOrder());
        int result = 0;
        int num = 9;
        for (int i = 0; i < customMap.length; i++) {
            if (customMap[i] != null) {
                result += customMap[i] * num;
                num--;
            }
        }

        bw.write(String.valueOf(result));

        br.close();
        bw.close();
    }
}
