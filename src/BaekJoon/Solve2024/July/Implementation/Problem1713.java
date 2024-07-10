package BaekJoon.Solve2024.July.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Problem1713 {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());

        int[] score = new int[101];
        Map<Integer, Integer> ord = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++) {
            int vote = Integer.parseInt(st.nextToken());

            if (list.contains(vote)) {
                score[vote]++;
            } else {
                if (list.size() == n) {
                    List<Integer> tmp = new ArrayList<>();
                    int m = 1000;
                    for (int mem : list) {
                        if (m > score[mem]) {
                            tmp.clear();
                            tmp.add(mem);
                            m = score[mem];
                        } else if (m == score[mem]) {
                            tmp.add(mem);
                        }
                    }

                    int del = 0;
                    if (tmp.size() == 1) {
                        del = tmp.get(0);
                    } else {
                        m = 1000;
                        for (int mem : tmp) {
                            if (m > ord.get(mem)) {
                                m = ord.get(mem);
                                del = mem;
                            }
                        }
                    }

                    list.remove((Integer) del);
                    score[del] = 0;
                    ord.remove(del);
                }

                ord.put(vote, i);
                list.add(vote);
            }
        }

        list.sort(Comparator.naturalOrder());
        for (int mem : list) {
            System.out.print(mem + " ");
        }

        br.close();
    }
}
