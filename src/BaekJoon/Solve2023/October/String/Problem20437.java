package BaekJoon.Solve2023.October.String;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Problem20437 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        List<Integer>[] arr = new ArrayList[26];
        for (int i = 0; i < 26; i++) arr[i] = new ArrayList<>();

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String src = br.readLine();
            int k = Integer.parseInt(br.readLine());

            for (int i = 0; i < 26; i++) arr[i].clear();

            for (int i = 0; i < src.length(); i++) {
                char c = src.charAt(i);

                arr[c - 'a'].add(i);
            }

            List<Integer> can = new ArrayList<>();
            for (int i = 0; i < 26; i++) {
                if (arr[i].size() >= k) can.add(i);
            }

            if (can.isEmpty()) {
                bw.write("-1");
                bw.newLine();
                continue;
            }

            int shortest = Integer.MAX_VALUE;
            int longest = 0;
            for (int i : can) {
                List<Integer> idxList = arr[i];
                for (int j = 0; j < idxList.size() - k + 1; j++) {
                    shortest = Math.min(shortest, idxList.get(j + k - 1) - idxList.get(j) + 1);
                    longest = Math.max(longest, idxList.get(j + k - 1) - idxList.get(j) + 1);
                }
            }

            bw.write(shortest + " " + longest);
            bw.newLine();
        }

        br.close();
        bw.close();
    }
}
