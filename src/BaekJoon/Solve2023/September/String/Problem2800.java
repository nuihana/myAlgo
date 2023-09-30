package BaekJoon.Solve2023.September.String;

import java.io.*;
import java.util.*;

public class Problem2800 {
    List<int[]> list = new ArrayList<>();
    Set<String> result = new TreeSet<>();
    boolean[] chk;
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == '(') {
                stack.push(i);
            } else if (c == ')') {
                list.add(new int[]{stack.pop(), i});
            }
        }

        chk = new boolean[str.length()];
        getResult(0, str.toCharArray());

        for (String res : result) {
            bw.write(res);
            bw.newLine();
        }

        br.close();
        bw.close();
    }

    private void getResult(int depth, char[] str) {
        if (depth == list.size()) {
            boolean flag = false;
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < str.length; i++) {
                if (!chk[i]) sb.append(str[i]);
                else flag = true;
            }
            if (flag) result.add(sb.toString());
            return;
        }

        getResult(depth + 1, str);

        int[] bracket = list.get(depth);
        chk[bracket[0]] = true;
        chk[bracket[1]] = true;
        getResult(depth + 1, str);
        chk[bracket[0]] = false;
        chk[bracket[1]] = false;
    }
}
