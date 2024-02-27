package BaekJoon.Solve2024.February.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem1593 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int wordLen = Integer.parseInt(st.nextToken());
        int srcLen = Integer.parseInt(st.nextToken());

        String word = br.readLine();
        String src = br.readLine();

        int[] wordAddr = new int[52];
        int[] addr = new int[52];
        for (int i = 0; i < wordLen; i++) {
            char c = word.charAt(i);
            add(wordAddr, c);
        }

        for (int i = 0; i < wordLen; i++) {
            char c = src.charAt(i);
            add(addr, c);
        }

        int res = 0;
        if (isSame(wordAddr, addr)) res++;

        for (int i = wordLen; i < srcLen; i++) {
            char bf = src.charAt(i - wordLen);
            rmv(addr, bf);

            char af = src.charAt(i);
            add(addr, af);

            if (isSame(wordAddr, addr)) res++;
        }

        System.out.print(res);

        br.close();
    }

    private void add(int[] arr, char c) {
        if (c > 'Z') {
            arr[c - 'a']++;
        } else {
            arr[c - 'A' + 26]++;
        }
    }

    private void rmv(int[] arr, char c) {
        if (c > 'Z') {
            arr[c - 'a']--;
        } else {
            arr[c - 'A' + 26]--;
        }
    }

    private boolean isSame(int[] a, int[] b) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] != b[i]) return false;
        }
        return true;
    }
}
