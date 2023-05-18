package BaekJoon.Solve2023.May.Random;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Problem1043 {
    int[] unionFind;
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int personCnt = Integer.parseInt(st.nextToken());
        int partyCnt = Integer.parseInt(st.nextToken());
        unionFind = new int[personCnt + 1];
        for (int i = 1; i <= personCnt; i++) {
            unionFind[i] = i;
        }

        st = new StringTokenizer(br.readLine());
        int knowCnt = Integer.parseInt(st.nextToken());
        for (int i = 0; i < knowCnt; i++) {
            unionFind[Integer.parseInt(st.nextToken())] = 0;
        }

        List<Integer>[] partyArr = new List[partyCnt];
        for (int i = 0; i < partyCnt; i++) {
            st = new StringTokenizer(br.readLine());
            int participateCnt = Integer.parseInt(st.nextToken());

            List<Integer> tmpPartyList = new ArrayList<>();
            for (int j = 0; j < participateCnt; j++) {
                tmpPartyList.add(Integer.parseInt(st.nextToken()));
            }

            partyArr[i] = tmpPartyList;
        }

        if (knowCnt == 0) {
            bw.write(String.valueOf(partyCnt));
        } else {
            int result = 0;
            boolean completed = true;
            while(completed) {
                result = partyCnt;
                completed = false;

                for (int i = 0; i < partyCnt; i++) {
                    int know = 0;
                    for (int p : partyArr[i]) {
                        if (find(p) == 0) {
                            result--;
                            know = p;
                            break;
                        }
                    }
                    if (know > 0) {
                        for (int p : partyArr[i]) {
                            if (find(p) != 0) {
                                union(know, p);
                                completed = true;
                            }
                        }
                    }
                }
            }

            bw.write(String.valueOf(result));
        }

        br.close();
        bw.close();
    }

    private int find(int idx) {
        while(unionFind[idx] != idx) {
            idx = unionFind[idx];
        }

        return idx;
    }
    private void union(int a, int b) {
        int root_a = find(a);
        int root_b = find(b);

        if (root_a != root_b) {
            unionFind[root_b] = root_a;
        }
    }
}
