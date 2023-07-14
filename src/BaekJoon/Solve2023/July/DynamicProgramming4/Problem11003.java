package BaekJoon.Solve2023.July.DynamicProgramming4;

import java.io.*;
import java.util.*;

public class Problem11003 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int numCnt = Integer.parseInt(st.nextToken());
        int range = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        Deque<int[]> deque = new ArrayDeque<>();
        for (int i = 0; i < numCnt; i++) {
            int n = Integer.parseInt(st.nextToken());

            if (!deque.isEmpty() && deque.peekFirst()[1] + range == i) deque.pollFirst();
            while (!deque.isEmpty() && deque.peekLast()[0] > n) deque.pollLast();
            deque.offerLast(new int[]{n, i});

            bw.write(deque.peekFirst()[0] +" ");
        }

        br.close();
        bw.close();
    }
}
