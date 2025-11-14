package BaekJoon.Solve2025.November.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem9342 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            String src = br.readLine();

            if (isValid(src)) sb.append("Infected!").append("\n");
            else sb.append("Good").append("\n");
        }
        System.out.print(sb);

        br.close();
    }

    private boolean isValid(String s) {
        int a = s.indexOf("A");
        int f = s.indexOf("F");
        int c = s.indexOf("C");

        int aLast = s.lastIndexOf("A");
        int fLast = s.lastIndexOf("F");
        if (s.charAt(s.length() - 1) == 'A' || s.charAt(s.length() - 1) == 'F' || s.charAt(s.length() - 1) == 'C') {
            if (a < f && f < c && aLast == f - 1 && fLast == c - 1) return true;
        }
        return false;
    }
}
