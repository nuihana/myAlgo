package BaekJoon.Solve2023.October.String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Problem3033 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int l = Integer.parseInt(br.readLine());
        String src = br.readLine();

        List<Integer> sa = getSuffixArray(src);
        int[] lcp = getLCP(src, sa);
        int res = 0;
        for (int i = 0; i < lcp.length; i++) {
            res = Math.max(res, lcp[i]);
        }

        System.out.print(res);

        br.close();
    }

    private List<Integer> getSuffixArray(String src) {
        int n = src.length();
        int t = 1;

        List<Integer> list = new ArrayList<>();
        int[] group = new int[n + 1];
        for (int i = 0; i < n; i++) {
            list.add(i);
            group[i] = src.charAt(i) - 'a';
        }
        group[n] = -1;

        JduComparator cpr = new JduComparator(n, t, group);
        while (t < n) {
            list.sort(cpr.comparator);
            t <<= 1;
            if (t >= n) break;

            int[] newGroup = new int[n + 1];
            newGroup[list.get(0)] = 0;
            newGroup[n] = -1;

            for (int i = 1; i < n; i++) {
                if (cpr.comparator.compare(list.get(i - 1), list.get(i)) < 0) {
                    newGroup[list.get(i)] = newGroup[list.get(i - 1)] + 1;
                } else {
                    newGroup[list.get(i)] = newGroup[list.get(i - 1)];
                }
            }
            group = newGroup;
            cpr.changeValues(t, group);
        }

        return list;
    }

    private int[] getLCP(String src, List<Integer> sa) {
        int n = sa.size();
        int[] lcp = new int[n - 1];

        int[] isa = new int[n]; // inverse of sa
        for (int i = 0; i < n; i++) {
            isa[sa.get(i)] = i;
        }

        int k = 0;
        for (int i = 0; i < n; i++) {
            int idx = isa[i];
            if (idx == n - 1) continue;

            int j = sa.get(idx + 1);
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
        private int n;
        private int t;
        private int[] group;

        private Comparator<Integer> comparator = new Comparator<>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (group[o1] != group[o2]) return group[o1] - group[o2];
                int left = o1 + t, right = o2+ t;
                if (left > n) left = n;
                if (right > n) right = n;
                return group[left] - group[right];
            }
        };

        public JduComparator(int n, int t, int[] group) {
            this.n = n;
            this.t = t;
            this.group = Arrays.copyOf(group, group.length);
        }

        public void changeValues(int t, int[] group) {
            this.t = t;
            this.group = group;
        }
    }
}
