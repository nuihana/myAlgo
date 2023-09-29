package BaekJoon.Solve2023.September.String;

import java.io.*;

public class Problem4354 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {
            String str = br.readLine();
            if (str.equals(".")) break;

            int[] table = getTable(str);
            int lastPi = table[str.length() - 1];

            if (str.length() % (str.length() - lastPi) != 0) bw.write("1");
            else bw.write(String.valueOf(str.length() / (str.length() - lastPi)));
            bw.newLine();
        }

        br.close();
        bw.close();
    }

    private int[] getTable(String str) {
        int[] res = new int[str.length()];

        int p = 0;
        for (int i = 1; i < str.length(); i++) {
            char c = str.charAt(i);
            while (p > 0 && c != str.charAt(p)) {
                p = res[p - 1];
            }

            if (c == str.charAt(p)) {
                res[i] = ++p;
            }
        }

        return res;
    }
}
