package BaekJoon.Solve2023.October.String;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Problem9248 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String src = br.readLine();
        List<Integer> suffixArray = makeSuffixArray(src);
        int[] lcp = getLCP(src, suffixArray);

        for (int suf : suffixArray) {
            bw.write((suf + 1) + " ");
        }
        bw.newLine();
        bw.write("x ");
        for (int cp : lcp) {
            bw.write(cp + " ");
        }

        br.close();
        bw.close();
    }

    private List<Integer> makeSuffixArray(String src) {
        int n = src.length();
        int t = 1;

        List<Integer> list = new ArrayList<>();
        int[] group = new int[n + 1];

        for (int i = 0; i < n; i++) {
            list.add(i);
            group[i] = src.charAt(i) - 'a';
        }
        group[n] = -1;

        JduComparator jcomp = new JduComparator(n, t, group);
        while (t < n) {
            list.sort(jcomp.comp);
            t <<= 1;
            if (t >= n) break;

            int[] newGroup = new int[n + 1];
            newGroup[list.get(0)] = 0;
            newGroup[n] = -1;

            for (int i = 1; i < n; i++) {
                if (jcomp.comp.compare(list.get(i - 1), list.get(i)) < 0) {
                    newGroup[list.get(i)] = newGroup[list.get(i - 1)] + 1;
                } else {
                    newGroup[list.get(i)] = newGroup[list.get(i - 1)];
                }
            }

            jcomp.setNewValue(t, newGroup);
        }

        return list;
    }

    private int[] getLCP(String src, List<Integer> suffixArray) {
        int n = suffixArray.size();

        int[] isa = new int[n];
        int[] lcp = new int[n - 1];
        for (int i = 0; i < n; i++) {
            isa[suffixArray.get(i)] = i;
        }

        int k = 0;
        for (int i = 0; i < n; i++) {
            int idx = isa[i];
            if (idx == n - 1) continue;

            int j = suffixArray.get(idx + 1);
            while (i + k < n && j + k < n) {
                if (src.charAt(i + k) != src.charAt(j + k)) break;
                k++;
            }

            lcp[idx] = k;
            if (k > 0) k--;
        }

        return lcp;
    }

    class JduComparator {
        int n;
        int t;
        int[] group;

        Comparator<Integer> comp = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (group[o1] != group[o2]) return group[o1] - group[o2];
                int left = o1 + t, right = o2 + t;
                if (left > n) left = n;
                if (right > n) right = n;
                return group[left] - group[right];
            }
        };

        public JduComparator(int n, int t, int[] group) {
            this.n = n;
            this.t = t;
            this.group = group;
        }

        public void setNewValue(int t, int[] group) {
            this.t = t;
            this.group = group;
        }
    }
}
