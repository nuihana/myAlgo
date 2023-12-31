package BaekJoon.Solve2023.December.Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem2644 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int personCnt = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int[] uf = new int[personCnt + 1];
        for (int i = 1; i <= personCnt; i++) uf[i] = i;
        int relationCnt = Integer.parseInt(br.readLine());
        for (int i = 0; i < relationCnt; i++) {
            st = new StringTokenizer(br.readLine());
            int parent = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());

            uf[child] = parent;
        }

        Integer[] aRelation = new Integer[personCnt + 1];
        int tmp = a;
        int ord = 0;
        while (tmp != uf[tmp]) {
            aRelation[tmp] = ord++;
            tmp = uf[tmp];
        }
        aRelation[tmp] = ord;

        tmp = b;
        ord = 0;
        int result = -1;
        while (tmp != uf[tmp]) {
            if (aRelation[tmp] != null) {
                result = aRelation[tmp] + ord;
                break;
            }
            ord++;
            tmp = uf[tmp];
        }
        if (aRelation[tmp] != null) result = aRelation[tmp] + ord;

        System.out.print(result);

        br.close();
    }
}
