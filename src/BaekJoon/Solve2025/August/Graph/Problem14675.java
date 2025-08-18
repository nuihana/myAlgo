package BaekJoon.Solve2025.August.Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Problem14675 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int nodeCnt = Integer.parseInt(br.readLine());
        List<Integer>[] tree = new List[nodeCnt + 1];
        for (int i = 1; i <= nodeCnt; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 1; i < nodeCnt; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            tree[a].add(b);
            tree[b].add(a);
        }

        int queryCnt = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (queryCnt-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int query = Integer.parseInt(st.nextToken());
            int idx = Integer.parseInt(st.nextToken());

            if (query == 1) {
                if (tree[idx].size() == 1) {
                    sb.append("no");
                } else {
                    sb.append("yes");
                }
            } else if (query == 2) {
                sb.append("yes");
            }
            sb.append("\n");
        }
        System.out.print(sb);

        br.close();
    }
}
