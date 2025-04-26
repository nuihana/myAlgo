package BaekJoon.Solve2025.April.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem14696 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (n-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int aCnt = Integer.parseInt(st.nextToken());
            int[] a = new int[6];
            while (st.hasMoreTokens()) {
                a[Integer.parseInt(st.nextToken())]++;
            }

            st = new StringTokenizer(br.readLine());
            int bCnt = Integer.parseInt(st.nextToken());
            int[] b = new int[6];
            while (st.hasMoreTokens()) {
                b[Integer.parseInt(st.nextToken())]++;
            }

            sb.append(compare(a, b)).append("\n");
        }
        System.out.print(sb);

        br.close();
    }

    private String compare(int[] a, int[] b) {
        for (int i = 5; i > 0; i--) {
            if (a[i] > b[i]) return "A";
            if (a[i] < b[i]) return "B";
        }
        return "D";
    }
}
