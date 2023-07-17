package BaekJoon.Solve2023.July.DynamicProgramming4;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Problem15678 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int cnt = Integer.parseInt(st.nextToken());
        int inter = Integer.parseInt(st.nextToken());

        Deque<long[]> dq = new ArrayDeque<>();
        long res = Long.MIN_VALUE;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < cnt; i++) {
            long val = Long.parseLong(st.nextToken());

            while(!dq.isEmpty() && dq.peekFirst()[1] < i - inter) dq.pollFirst(); // 현재 다리로 올 수 없는 후보군 제거

            if (!dq.isEmpty()) val = Math.max(val, val + dq.peekFirst()[0]); // 현재 다리가 시작인 경우와, 이전 최적해에서 건너온 경우 비교
            res = Math.max(res, val);

            while(!dq.isEmpty() && dq.peekLast()[0] <= val) dq.pollLast(); // 현재의 최적해보다 작은 값 제거

            dq.offerLast(new long[]{val, i});
        }

        bw.write(String.valueOf(res));

        br.close();
        bw.close();
    }
}
