package BaekJoon.Solve2025.August.Backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem16943 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        String a = st.nextToken();
        int[] aCnt = new int[10];
        for (int i = 0; i < a.length(); i++) {
            aCnt[a.charAt(i) - '0']++;
        }

        int b = Integer.parseInt(st.nextToken());
        System.out.print(search(aCnt, new int[a.length()], 0, b));

        br.close();
    }

    private int search(int[] cnt, int[] val, int n, int cpr) {
        if (n == val.length) {
            int intVal = makeInt(val);
            if (intVal < cpr) return intVal;
            else return -1;
        }

        int res = -1;
        for (int i = 9; i >= 0; i--) {
            if (cnt[i] > 0 && !(i == 0 && n == 0)) {
                val[n] = i;
                cnt[i]--;
                res = Math.max(res, search(cnt, val, n + 1, cpr));
                cnt[i]++;
            }
        }
        return res;
    }

    private int makeInt(int[] arr) {
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            res += arr[i] * Math.pow(10, arr.length - i - 1);
        }
        return res;
    }
}
