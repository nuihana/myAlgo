package BaekJoon.Solve2024.June.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Problem1251 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String src = br.readLine();
        List<String> list = new ArrayList<>();
        for (int i = 0; i < src.length() - 1; i++) {
            for (int j = i + 1; j < src.length() - 1; j++) {
                list.add(makeWord(i, j, src));
            }
        }
        list.sort(Comparator.naturalOrder());
        System.out.print(list.get(0));

        br.close();
    }

    private String makeWord(int n, int m, String src) {
        StringBuilder sb = new StringBuilder();
        for (int i = n; i >= 0; i--) {
            sb.append(src.charAt(i));
        }
        for (int j = m; j > n; j--) {
            sb.append(src.charAt(j));
        }
        for (int k = src.length() - 1; k > m; k--) {
            sb.append(src.charAt(k));
        }
        return sb.toString();
    }
}
