package BaekJoon.Solve2023.GraphAndCircuit;

import java.io.*;
import java.util.*;

public class Problem16928 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int ladderCnt = Integer.parseInt(st.nextToken());
        int snakeCnt = Integer.parseInt(st.nextToken());
        int[] field = new int[101];

        Map<Integer, Integer> switchMap = new HashMap<>();
        for (int i = 0; i < ladderCnt; i++) {
            st = new StringTokenizer(br.readLine());
            switchMap.put(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        for (int i = 0; i < snakeCnt; i++) {
            st = new StringTokenizer(br.readLine());
            switchMap.put(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        Queue<Integer> que = new LinkedList<>();
        que.add(1);
        int turnCnt = 1;
        int pointCnt = 1;
        while(field[100] == 0) {
            for (int i = 0, iLimit = pointCnt; i < iLimit; i++) {
                int tmp = que.poll();
                int maximumMove = 0;

                for (int j = tmp + 1, jLimit = tmp + 6; j <= jLimit; j++) {
                    if (field[j] == 0) {
                        field[j] = turnCnt;
                    }

                    if (switchMap.get(j) != null) {
                        int switcher = switchMap.get(j);

                        if (field[switcher] == 0) {
                            field[switcher] = turnCnt;
                            que.add(switcher);
                            pointCnt++;
                        }
                    } else {
                        maximumMove = j;
                    }
                }

                que.add(maximumMove);
            }
            turnCnt++;
        }

        bw.write(String.valueOf(field[100]));

        br.close();
        bw.close();
    }
}
