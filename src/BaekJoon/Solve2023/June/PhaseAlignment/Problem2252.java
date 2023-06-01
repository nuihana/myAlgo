package BaekJoon.Solve2023.June.PhaseAlignment;

import java.io.*;
import java.util.*;

public class Problem2252 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int studentCnt = Integer.parseInt(st.nextToken());
        int cprCnt = Integer.parseInt(st.nextToken());

        int[] conditionArr = new int[studentCnt + 1];
        Map<Integer, List<Integer>> cprMap = new HashMap<>();
        for (int i = 0; i < cprCnt; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (cprMap.get(a) == null) {
                List<Integer> tmpList = new ArrayList<>();

                tmpList.add(b);

                cprMap.put(a, tmpList);
            } else {
                cprMap.get(a).add(b);
            }

            conditionArr[b]++;
        }

        Queue<Integer> que = new LinkedList<>();

        for (int i = 1; i <= cprCnt; i++) {
            if(conditionArr[i] == 0) {
                que.offer(i);
            }
        }

        Queue<Integer> result = new LinkedList<>();
        while(!que.isEmpty()) {
            int num = que.poll();

            if (cprMap.get(num) != null) {
                for (int next : cprMap.get(num)) {
                    conditionArr[next]--;

                    if (conditionArr[next] == 0) {
                        que.offer(next);
                    }
                }
            }

            result.offer(num);
        }

        while (!result.isEmpty()) {
            bw.write(result.poll() + " ");
        }

        br.close();
        bw.close();
    }
}
