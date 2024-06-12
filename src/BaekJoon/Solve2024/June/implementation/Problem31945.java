package BaekJoon.Solve2024.June.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Problem31945 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Set<String> cube = new HashSet<>();
        cube.add("0123");
        cube.add("0145");
        cube.add("0246");
        cube.add("1357");
        cube.add("2367");
        cube.add("4567");
        int testCaseCnt = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (testCaseCnt-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] arr = new int[4];
            for (int i = 0; i < 4; i++) arr[i] = Integer.parseInt(st.nextToken());
            Arrays.sort(arr);

            StringBuilder tmp = new StringBuilder();
            for (int n : arr) tmp.append(n);
            String src = tmp.toString();

            if (cube.contains(src)) sb.append("YES").append("\n");
            else sb.append("NO").append("\n");
        }
        System.out.print(sb);

        br.close();
    }
}
