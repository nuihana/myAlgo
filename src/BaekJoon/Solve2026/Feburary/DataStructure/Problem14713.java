package BaekJoon.Solve2026.Feburary.DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Problem14713 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        Queue<String>[] qArr = new Queue[n];
        for (int i = 0; i < n; i++) {
            qArr[i] = new LinkedList<>();
            StringTokenizer st = new StringTokenizer(br.readLine());

            while (st.hasMoreTokens()) {
                qArr[i].add(st.nextToken());
            }
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        boolean isPossible = true;
        while (st.hasMoreTokens() && isPossible) {
            String next = st.nextToken();

            boolean singleChk = false;
            for (Queue<String> q : qArr) {
                if (!q.isEmpty() && q.peek().equals(next)) {
                    q.poll();
                    singleChk = true;
                    break;
                }
            }

            if (!singleChk) {
                isPossible = false;
                break;
            }
        }

        for (Queue<String> q : qArr) {
            if (!q.isEmpty()) {
                isPossible = false;
                break;
            }
        }

        if (isPossible) System.out.print("Possible");
        else System.out.print("Impossible");

        br.close();
    }
}
