package BaekJoon.Solve2025.April.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Problem1371 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] arr = new int[26];
        while (true) {
            String src = br.readLine();

            if (src == null) break;
            for (int i = 0; i < src.length(); i++) {
                char c = src.charAt(i);
                if (c == ' ') continue;
                arr[c - 'a']++;
            }
        }

        List<Integer> res = new ArrayList<>();
        int amo = 0;
        for (int i = 0; i < 26; i++) {
            if (arr[i] > amo) {
                amo = arr[i];
                res.clear();
                res.add(i);
            } else if (arr[i] == amo) {
                res.add(i);
            }
        }

        for (int c : res) {
            System.out.print((char) (c + 'a'));
        }

        br.close();
    }
}
