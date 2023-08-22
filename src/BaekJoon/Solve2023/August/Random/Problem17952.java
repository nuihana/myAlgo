package BaekJoon.Solve2023.August.Random;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Problem17952 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        Stack<int[]> stack = new Stack<>();
        int res = 0;
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();

            if (command.equals("1")) {
                int score = Integer.parseInt(st.nextToken());
                int time = Integer.parseInt(st.nextToken());
                stack.push(new int[]{score, time, 0});
            }

            if (!stack.isEmpty()) {
                int[] work = stack.pop();
                work[2]++;

                if (work[1] == work[2]) {
                    res += work[0];
                    continue;
                }

                stack.push(work);
            }
        }

        bw.write(String.valueOf(res));

        br.close();
        bw.close();
    }
}
