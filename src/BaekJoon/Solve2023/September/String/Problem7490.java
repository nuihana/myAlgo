package BaekJoon.Solve2023.September.String;

import java.io.*;
import java.util.*;

public class Problem7490 {
    char[] arr;
    List<String> list = new ArrayList<>();
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int testCase = Integer.parseInt(br.readLine());
        while (testCase-- > 0) {
            int n = Integer.parseInt(br.readLine());

            arr = new char[n - 1];
            dfs(n, 0);

            list.sort(Comparator.naturalOrder());
            for (String s : list) {
                bw.write(s);
                bw.newLine();
            }
            bw.newLine();
        }

        br.close();
        bw.close();
    }

    private void dfs(int n, int i) {
        if (n - 1 == i) {
            calc();
            return;
        }

        arr[i] = '+';
        dfs(n, i + 1);

        arr[i] = '-';
        dfs(n, i + 1);

        arr[i] = ' ';
        dfs(n, i + 1);
    }

    private void calc() {
        List<Integer> nums = new ArrayList<>();
        List<Character> oper = new ArrayList<>();

        for (int i = 0, n = 0; i <= arr.length; i++) {
            n += i + 1;

            if (i < arr.length && arr[i] == ' ') {
                n *= 10;
                continue;
            }

            nums.add(n);
            if (i < arr.length) {
                oper.add(arr[i]);
            }
            n = 0;
        }

        int res = nums.get(0);
        for (int i = 0; i < oper.size(); i++) {
            char c = oper.get(i);
            if (c == '+') res += nums.get(i + 1);
            if (c == '-') res -= nums.get(i + 1);
        }

        if (res == 0) {
            StringBuilder sb = new StringBuilder();
            sb.append(1);
            for (int i = 0; i < arr.length; i++) {
                sb.append(arr[i]).append(i + 2);
            }

            list.add(sb.toString());
        }
    }
}
