package BaekJoon.Solve2023.July.BipartiteMatching;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Problem1017 {
    boolean[] prime;
    List<List<Integer>> list;
    int[] aMatch, bMatch;
    boolean[] done;
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int cnt = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[cnt];
        for (int i = 0; i < cnt; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        List<Integer> aList = new ArrayList<>();
        List<Integer> bList = new ArrayList<>();
        boolean isFirstEven = arr[0] % 2 == 0;
        aList.add(arr[0]);

        for (int i = 1; i < cnt; i++) {
            if (isFirstEven) {
                if (arr[i] % 2 == 0) {
                    aList.add(arr[i]);
                } else {
                    bList.add(arr[i]);
                }
            } else {
                if (arr[i] % 2 != 0) {
                    aList.add(arr[i]);
                } else {
                    bList.add(arr[i]);
                }
            }
        }

        if (aList.size() != bList.size()) {
            bw.write("-1");
        } else {
            list = new ArrayList<>();

            for (int i = 0; i < aList.size(); i++) {
                List<Integer> tmp = new ArrayList<>();
                int now = aList.get(i);
                for (int j = 0; j < bList.size(); j++) {
                    int plus = bList.get(j);
                    if (isPrime(now + plus))tmp.add(j);
                }

                list.add(tmp);
            }

            List<Integer> ans = new ArrayList<>();
            for (int i = 0; i < list.get(0).size(); i++) {
                int pairIdx = list.get(0).get(i);
                int pairSize = 1;

                aMatch = new int[aList.size()];
                bMatch = new int[bList.size()];
                Arrays.fill(aMatch, -1);
                Arrays.fill(bMatch, -1);

                aMatch[0] = pairIdx;
                bMatch[pairIdx] = 0;

                for (int j = 1; j < aList.size(); j++) {
                    done = new boolean[aList.size()];
                    if (dfs(j)) pairSize++;
                }

                if (pairSize == bList.size()) ans.add(bList.get(pairIdx));
            }

            if (ans.size() > 0) {
                ans.sort((i1, i2) -> i1 - i2);
                for (int n : ans) {
                    bw.write(n + " ");
                }
            } else {
                bw.write("-1");
            }
        }

        br.close();
        bw.close();
    }

    private boolean isPrime(int n) {
        if (prime == null) {
            prime = initPrime(2000);
        }

        return !prime[n];
    }

    private boolean[] initPrime(int l) {
        boolean[] res = new boolean[l + 1];
        for (int i = 2; i <= l; i++) {
            for (int j = 2; j * i <= l; j++) {
                res[i * j] = true;
            }
        }
        return res;
    }

    private boolean dfs(int n) {
        if (n == 0 || done[n]) return false;
        done[n] = true;

        for (int i = 0; i < list.get(n).size(); i++) {
            int b = list.get(n).get(i);

            if (bMatch[b] == -1 || dfs(bMatch[b])) {
                aMatch[n] = b;
                bMatch[b] = n;
                return true;
            }
        }
        return false;
    }
}
