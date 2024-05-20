package BaekJoon.Solve2024.May.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Problem2304 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int pillarCnt = Integer.parseInt(br.readLine());
        int maxWidth = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a1, a2) -> a2[1] - a1[1]);
        for (int i = 0; i < pillarCnt; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int location = Integer.parseInt(st.nextToken());
            int height = Integer.parseInt(st.nextToken());

            pq.offer(new int[]{ location, height });
            maxWidth = Math.max(maxWidth, location);
        }

        int[] info = new int[maxWidth + 1];
        int[] start = pq.poll();
        int center = start[0];
        info[start[0]] = start[1];
        while (!pq.isEmpty()) {
            int[] now = pq.poll();

            if (now[0] > center) {
                for (int i = now[0]; i > center; i--) {
                    if (info[i] != 0) break;
                    info[i] = now[1];
                }
            } else {
                for (int i = now[0]; i < center; i++) {
                    if (info[i] != 0) break;
                    info[i] = now[1];
                }
            }
        }

        int res = 0;
        for (int i = 0; i < info.length; i++) {
            res += info[i];
        }
        System.out.print(res);

        br.close();
    }
}
