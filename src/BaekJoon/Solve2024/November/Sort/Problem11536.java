package BaekJoon.Solve2024.November.Sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Problem11536 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String[] src = new String[n];
        String[] sort = new String[n];
        for (int i = 0; i < n; i++) {
            src[i] = br.readLine();
            sort[i] = src[i];
        }

        Arrays.sort(sort);
        if (isSameOrd(src, sort)) {
            System.out.print("INCREASING");
            return;
        }

        Arrays.sort(sort, (s1, s2) -> s2.compareTo(s1));
        if (isSameOrd(src, sort)) {
            System.out.print("DECREASING");
            return;
        }

        System.out.print("NEITHER");

        br.close();
    }

    private boolean isSameOrd(String[] src, String[] cpr) {
        for (int i = 0; i < src.length; i++) {
            if (!src[i].equals(cpr[i])) return false;
        }
        return true;
    }
}
