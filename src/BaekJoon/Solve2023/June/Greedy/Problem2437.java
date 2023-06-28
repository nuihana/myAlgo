package BaekJoon.Solve2023.June.Greedy;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem2437 {
    int[] arr;
    int[] pos = new int[1000000000];
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int cnt = Integer.parseInt(br.readLine());
        arr = new int[cnt];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < cnt; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            pos[arr[i]]++;
        }

        Arrays.sort(arr);
        for (int i = 2; i < cnt; i++) {
            int[] tmp = new int[i];
            int max = getCase(tmp, i, 0);
            int chk = chk(max);
            if (chk > 0) {
                bw.write(String.valueOf(chk));
                bw.newLine();
                break;
            }
        }

        br.close();
        bw.close();
    }

    private int getCase(int[] seq, int until, int idx) {
        if (idx == until) {
            int val = 0;
            for (int j : seq) {
                val += j;
            }
            if (pos[val] == 0) {
                pos[val]++;
            }
            return val;
        }

        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            seq[idx] = arr[i];
            max = Math.max(max, getCase(seq, until, idx + 1));
        }
        return max;
    }

    private int chk(int until) {
        for (int i = 1; i <= until; i++) {
            if (pos[i] == 0) {
                return i;
            }
        }
        return -1;
    }
}
