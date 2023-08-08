package BaekJoon.Solve2023.August.Greedy;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem2812 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        String input = br.readLine();
        Queue<Integer>[] idxQue = new LinkedList[10];
        for (int i = 0; i < 10; i++) idxQue[i] = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            char c = input.charAt(i);
            idxQue[c - 48].offer(i);
        }

        StringBuilder sb = new StringBuilder();
        int max = 9;
        int idx = 0;
        while (k > 0) {
            while (idxQue[max].isEmpty() || idxQue[max].peek() - idx > k) {
                max--;
            }

            while(input.charAt(idx) - 48 != max) {
                idxQue[input.charAt(idx) - 48].poll();
                idx++;
                k--;
            }

            idxQue[input.charAt(idx) - 48].poll();
            sb.append(input.charAt(idx));
            idx++;
            if (n - idx == k) break;
            max = 9;
        }

        if (k == 0) sb.append(input.substring(idx));
        bw.write(sb.toString());

        br.close();
        bw.close();
    }
}
