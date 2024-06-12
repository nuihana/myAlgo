package BaekJoon.Solve2024.June.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Problem2628 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int height = Integer.parseInt(st.nextToken());
        int width = Integer.parseInt(st.nextToken());

        PriorityQueue<Integer> horizontalPQ = new PriorityQueue<>();
        PriorityQueue<Integer> verticalPQ = new PriorityQueue<>();
        int cutCnt = Integer.parseInt(br.readLine());
        while (cutCnt-- > 0) {
            st = new StringTokenizer(br.readLine());

            int direction = Integer.parseInt(st.nextToken());
            int idx = Integer.parseInt(st.nextToken());

            if (direction == 0) {
                horizontalPQ.offer(idx);
            } else {
                verticalPQ.offer(idx);
            }
        }

        Queue<Integer> horizontalQ = new LinkedList<>();
        Queue<Integer> verticalQ = new LinkedList<>();
        while (!horizontalPQ.isEmpty()) horizontalQ.offer(horizontalPQ.poll());
        while (!verticalPQ.isEmpty()) verticalQ.offer(verticalPQ.poll());
        horizontalQ.offer(width);
        verticalQ.offer(height);
        List<Integer> heights = new ArrayList<>();
        int bf = 0;
        while (!verticalQ.isEmpty()) {
            int now = verticalQ.poll();
            heights.add(now - bf);
            bf = now;
        }

        int max = -1;
        bf = 0;
        while (!horizontalQ.isEmpty()) {
            int now = horizontalQ.poll();
            for (int i = 0; i < heights.size(); i++) {
                max = Math.max(max, (now - bf) * heights.get(i));
            }
            bf = now;
        }

        System.out.print(max);

        br.close();
    }
}
