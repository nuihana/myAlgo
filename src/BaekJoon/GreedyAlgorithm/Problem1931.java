package BaekJoon.GreedyAlgorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Problem1931 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int valCnt = Integer.parseInt(br.readLine());
        List<int[]> valList = new ArrayList<>();

        for (int i = 0; i < valCnt; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int[] value = new int[2];
            value[0] = Integer.parseInt(st.nextToken());
            value[1] = Integer.parseInt(st.nextToken());

            valList.add(value);
        }

        valList.sort(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] - o2[1] == 0) {
                    return o1[0] - o2[0];
                } else {
                    return o1[1] - o2[1];
                }
            }
        });

        int result = 0;

        for (int i = 0, time = 0; i < valCnt; i++) {
            if (valList.get(i)[0] >= time) {
                time = valList.get(i)[1];
                result++;
            }
        }

        System.out.print(result);

        br.close();
    }
}
