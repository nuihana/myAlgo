package BaekJoon.Solve2025.May.Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Problem1252 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        Stack<Integer> a = new Stack<>();
        Stack<Integer> b = new Stack<>();

        String src = st.nextToken();
        for (int i = 0; i < src.length(); i++) {
            a.push(Integer.parseInt(src.charAt(i) + ""));
        }

        src = st.nextToken();
        for (int i = 0; i < src.length(); i++) {
            b.push(Integer.parseInt(src.charAt(i) + ""));
        }

        StringBuilder sb = new StringBuilder();
        int upper = 0;
        while (!a.isEmpty() || !b.isEmpty()) {
            int base = a.isEmpty() ? 0 : a.pop();
            base += b.isEmpty() ? 0 : b.pop();

            base += upper;
            upper = 0;

            if (base > 1) {
                base -= 2;
                upper = 1;
            }
            sb.append(base);
        }
        if (upper > 0) sb.append(upper);

        String res = sb.reverse().toString();
        sb = new StringBuilder();
        boolean start = true;
        for (int i = 0; i < res.length(); i++) {
            if (res.charAt(i) == '1') {
                start = false;
            }

            if (!start) sb.append(res.charAt(i));
        }

        if (sb.length() == 0) sb.append("0");
        System.out.print(sb);

        br.close();
    }
}
