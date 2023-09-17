package BaekJoon.Solve2023.September.String;

import java.io.*;

public class Problem1958 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str1 = br.readLine();
        String str2 = br.readLine();
        String str3 = br.readLine();

        bw.write(String.valueOf(lcs(str1, str2, str3)));

        br.close();
        bw.close();
    }

    private int lcs(String str1, String str2, String str3) {
        int[][][] mem = new int[str1.length() + 1][str2.length() + 1][str3.length() + 1];

        for (int i = 1; i <= str1.length(); i++) {
            char c1 = str1.charAt(i - 1);
            for (int j = 1; j <= str2.length(); j++) {
                char c2 = str2.charAt(j - 1);
                for (int k = 1; k <= str3.length(); k++) {
                    char c3 = str3.charAt(k - 1);

                    if (c1 == c2 && c2 == c3) mem[i][j][k] = mem[i - 1][j - 1][k - 1] + 1;
                    else mem[i][j][k] = Math.max(mem[i - 1][j][k], Math.max(mem[i][j - 1][k], mem[i][j][k - 1]));
                }
            }
        }

        return mem[str1.length()][str2.length()][str3.length()];
    }
}
