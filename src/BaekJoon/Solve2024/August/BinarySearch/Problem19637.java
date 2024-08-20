package BaekJoon.Solve2024.August.BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem19637 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] ceils = new int[n];
        String[] strs = new String[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            int ceil = Integer.parseInt(st.nextToken());

            ceils[i] = ceil;
            strs[i] = str;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            int power = Integer.parseInt(br.readLine());
            int id = search(ceils, power);
            sb.append(strs[id]).append("\n");
        }
        System.out.print(sb);

        br.close();
    }

    private int search(int[] ceils, int power) {
        int l = 0, r = ceils.length - 1, res = 0;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (ceils[mid] >= power) {
                res = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return res;
    }
}
