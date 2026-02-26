package BaekJoon.Solve2026.Feburary.DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Problem9322 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            int cnt = Integer.parseInt(br.readLine());

            Map<String, Integer> map = new HashMap<>();
            int[] ord = new int[cnt];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < cnt; i++) {
                map.put(st.nextToken(), i);
            }

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < cnt; i++) {
                String key = st.nextToken();
                ord[i] = map.get(key);
            }

            st = new StringTokenizer(br.readLine());
            String[] res = new String[cnt];
            for (int i = 0; i < cnt; i++) {
                String val = st.nextToken();
                res[ord[i]] = val;
            }

            for (int i = 0; i < cnt; i++) {
                sb.append(res[i]);
            }
            sb.append("\n");
        }
        System.out.print(sb);

        br.close();
    }
}
