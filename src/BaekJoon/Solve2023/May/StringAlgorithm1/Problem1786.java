package BaekJoon.Solve2023.May.StringAlgorithm1;

import java.io.*;
import java.util.*;

public class Problem1786 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String origin = br.readLine();
        String search = br.readLine();

        char[] searchChar = new char[search.length()];
        for (int j = 0; j < search.length(); j++) {
            searchChar[j] = search.charAt(j);
        }

        List<Integer> result = new ArrayList<>();
        int[] table = makeTable(search);
        int idx = 0;
        for (int i = 0; i < origin.length(); i++) {
            while(idx > 0 && origin.charAt(i) != search.charAt(idx)) {
                idx = table[idx - 1];
            }

            if (origin.charAt(i) == search.charAt(idx)) {
                if (idx == search.length() - 1) {
                    result.add(i - idx + 1);
                    idx = table[idx];
                } else {
                    idx++;
                }
            }
        }

        bw.write(String.valueOf(result.size()));
        bw.newLine();
        for (int num : result) {
            bw.write(num + " ");
        }

        br.close();
        bw.close();
    }

    private int[] makeTable(String str) {
        int[] result = new int[str.length()];

        int idx = 0;
        for (int i = 1; i < str.length(); i++) {
            while(idx > 0 && str.charAt(i) != str.charAt(idx)) {
                idx = result[idx - 1];
            }

            if (str.charAt(i) == str.charAt(idx)) {
                idx++;
                result[i] = idx;
            }
        }

        return result;
    }
}
