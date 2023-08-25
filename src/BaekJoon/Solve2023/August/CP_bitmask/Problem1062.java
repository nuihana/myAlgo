package BaekJoon.Solve2023.August.CP_bitmask;

import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Problem1062 {
    int[] word;
    Set<Integer> fixChar;
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        if (m < 5) { // a, n, t, i, c 가 반드시 포함되어야 함
            bw.write("0");
        } else {
            word = new int[n];
            for (int i = 0; i < n; i++) {
                String input = br.readLine();
                int inputBit = 0;
                for (int j = 0; j < input.length(); j++) {
                    int tmp = (1 << (input.charAt(j) - 97));
                    inputBit = inputBit | tmp;
                }
                word[i] = inputBit;
            }

            fixChar = new HashSet<>();
            int bit = 0;
            bit = bit | (1 << ('a' - 97));
            fixChar.add('a' - 97);
            bit = bit | (1 << ('c' - 97));
            fixChar.add('c' - 97);
            bit = bit | (1 << ('i' - 97));
            fixChar.add('i' - 97);
            bit = bit | (1 << ('n' - 97));
            fixChar.add('n' - 97);
            bit = bit | (1 << ('t' - 97));
            fixChar.add('t' - 97);

            m -= 5;
            bw.write(String.valueOf(dfs(bit, m, 0)));
        }

        br.close();
        bw.close();
    }

    private int dfs(int bit, int select, int idx) {
        if (select == 0) {
            int res = 0;
            for (int j : word) {
                if ((bit & j) == j) res++;
            }
            return res;
        }

        int res = Integer.MIN_VALUE;
        for (int i = idx; i < 26; i++) {
            if (fixChar.contains(i)) continue;
            res = Math.max(res, dfs(bit | (1 << i), select - 1, i + 1));
        }
        return res;
    }
}
