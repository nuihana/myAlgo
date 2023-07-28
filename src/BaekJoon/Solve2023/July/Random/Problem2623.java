package BaekJoon.Solve2023.July.Random;

import java.io.*;
import java.util.*;

public class Problem2623 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int nodeCnt = Integer.parseInt(st.nextToken());
        int conditionCnt = Integer.parseInt(st.nextToken());

        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i <= nodeCnt; i++) {
            list.add(new ArrayList<>());
        }

        int[] node = new int[nodeCnt + 1];
        for (int i = 0; i < conditionCnt; i++) {
            st = new StringTokenizer(br.readLine());
            int cnt = Integer.parseInt(st.nextToken());

            if (cnt == 0) continue;
            int before = Integer.parseInt(st.nextToken());
            while(st.hasMoreTokens()) {
                int now = Integer.parseInt(st.nextToken());
                node[now]++;
                list.get(before).add(now);
                before = now;
            }
        }

        Queue<Integer> que = new LinkedList<>();
        for (int i = 1; i <= nodeCnt; i++) {
            if (node[i] == 0) {
                que.offer(i);
            }
        }

        List<Integer> res = new ArrayList<>();
        while(!que.isEmpty()) {
            int now = que.poll();
            res.add(now);

            for (int next : list.get(now)) {
                node[next]--;
                if (node[next] == 0) que.offer(next);
            }
        }

        if (res.size() < nodeCnt) {
            bw.write("0");
        } else {
            for (int n : res) {
                bw.write(String.valueOf(n));
                bw.newLine();
            }
        }

        br.close();
        bw.close();
    }
}
