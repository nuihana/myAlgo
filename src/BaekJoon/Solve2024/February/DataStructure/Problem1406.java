package BaekJoon.Solve2024.February.DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Problem1406 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        int commandCnt = Integer.parseInt(br.readLine());
        Stack<Character> left = new Stack<>();
        Stack<Character> right = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            left.push(str.charAt(i));
        }

        for (int i = 0; i < commandCnt; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();

            if (command.equals("L")) {
                if (left.isEmpty()) continue;
                right.push(left.pop());
            } else if (command.equals("D")) {
                if (right.isEmpty()) continue;
                left.push(right.pop());
            } else if (command.equals("B")) {
                if (left.isEmpty()) continue;
                left.pop();
            } else {
                String add = st.nextToken();
                left.push(add.charAt(0));
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!left.isEmpty()) sb.append(left.pop());
        sb.reverse();
        while (!right.isEmpty()) sb.append(right.pop());

        System.out.print(sb);

        br.close();
    }
}
