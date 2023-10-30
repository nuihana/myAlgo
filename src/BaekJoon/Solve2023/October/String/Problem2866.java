package BaekJoon.Solve2023.October.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Problem2866 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        char[][] arr = new char[r][c];
        for (int i = 0; i < r; i++) {
            String line = br.readLine();
            for (int j = 0; j < c; j++) {
                char rc = line.charAt(j);
                arr[i][j] = rc;
            }
        }

        String[] strs = new String[c];
        Arrays.fill(strs, "");
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                strs[j] = strs[j].concat(String.valueOf(arr[i][j]));
            }
        }

        int ans = 0;
        for (int i = 0; i < r; i++) {
            if (!isDupl(strs, i + 1)) break;
            ans++;
        }
        System.out.print(ans);

        br.close();
    }

    private boolean isDupl(String[] strs, int cut) {
        Set<String> set = new HashSet<>();
        for (String str : strs) {
            String now = str.substring(cut);
            if (set.contains(now)) return false;
            set.add(now);
        }
        return true;
    }
}
