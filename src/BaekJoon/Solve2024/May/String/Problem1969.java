package BaekJoon.Solve2024.May.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.StringTokenizer;

public class Problem1969 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int cnt = Integer.parseInt(st.nextToken());
        int len = Integer.parseInt(st.nextToken());

        String[] dnas = new String[cnt];
        for (int i = 0; i < cnt; i++) {
            dnas[i] = br.readLine();
        }

        StringBuilder sb = new StringBuilder();
        int diff = 0;
        for (int i = 0; i < len; i++) {
            int[] freq = new int[26];

            for (int j = 0; j < cnt; j++) {
                freq[dnas[j].charAt(i) - 'A']++;
            }

            int idx = -1;
            int max = 0;
            for (int k = 0; k < 26; k++) {
                if (freq[k] > max) {
                    max = freq[k];
                    idx = k;
                }
            }

            sb.append((char) ('A' + idx));
            diff += cnt - max;
        }

        System.out.println(sb);
        System.out.print(diff);

        br.close();
    }
}
