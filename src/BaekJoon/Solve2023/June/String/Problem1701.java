package BaekJoon.Solve2023.June.String;

import java.io.*;

public class Problem1701 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();
        int result = 0;
        for (int i = 0; i < str.length(); i++) {
            int[] table = makeTable(str.substring(i));

            for (int j = 0; j < table.length; j++) {
                result = Math.max(result, table[j]);
            }
        }

        bw.write(String.valueOf(result));

        br.close();
        bw.close();
    }

    private int[] makeTable(String str) {
        int[] table = new int[str.length()];

        int idx = 0;
        for (int i = 1; i < str.length(); i++) {
            while(idx > 0 && str.charAt(i) != str.charAt(idx)) {
                idx = table[idx - 1];
            }

            if (str.charAt(i) == str.charAt(idx)) {
                idx++;
                table[i] = idx;
            }
        }

        return table;
    }
}
