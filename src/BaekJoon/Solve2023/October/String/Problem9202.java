package BaekJoon.Solve2023.October.String;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class Problem9202 {
    char[][] boggle = new char[4][4];
    boolean[][] used = new boolean[4][4];
    Set<String> findSet = new HashSet<>();
    int[] dx = {-1, 0, 1, -1, 1, -1, 0, 1};
    int[] dy = {-1, -1, -1, 0, 0, 1, 1, 1};
    int[] score = {0, 0, 0, 1, 1, 2, 3, 5, 11};

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int wordCnt = Integer.parseInt(br.readLine());
        Tri tri = new Tri();
        for (int i = 0; i < wordCnt; i++) {
            String word = br.readLine();
            tri.addWord(word);
        }
        br.readLine();

        int boggleCnt = Integer.parseInt(br.readLine());
        for (int i = 0; i < boggleCnt; i++) {
            for (int j = 0; j < 4; j++) {
                String line = br.readLine();
                for (int k = 0; k < 4; k++) {
                    boggle[j][k] = line.charAt(k);
                }
            }
            findSet.clear();

            for (int j = 0; j < 4; j++) {
                for (int k = 0; k < 4; k++) {
                    tri.search(j, k, "");
                }
            }

            String longest = "";
            int max = 0, matched = findSet.size(), scoreSum = 0;
            for (String item : findSet) {
                if (max == item.length()) {
                    longest = compareString(longest, item) ? longest : item;
                } else if (max < item.length()) {
                    max = item.length();
                    longest = item;
                }

                scoreSum += score[item.length()];
            }

            bw.write(scoreSum + " " + longest + " " + matched);
            bw.newLine();
        }

        br.close();
        bw.close();
    }

    private boolean compareString(String a, String b) {
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) == b.charAt(i)) continue;
            return a.charAt(i) < b.charAt(i);
        }
        return true;
    }

    class Tri {
        Tri[] dic;
        boolean isWordEnd;

        public Tri() {
            dic = new Tri[26];
            isWordEnd = false;
        }

        public void addWord(String word) {
            Tri bookmark = this;

            for (int i = 0; i < word.length(); i++) {
                int idx = word.charAt(i) - 'A';

                if (bookmark.dic[idx] == null) bookmark.dic[idx] = new Tri();
                bookmark = bookmark.dic[idx];
            }

            bookmark.isWordEnd = true;
        }
        public void search(int y, int x, String key) {
            if (key.length() > 8) return;
            used[y][x] = true;
            key = key.concat(boggle[y][x] + "");

            Tri node = this.dic[boggle[y][x] - 'A'];
            if (node == null) {
                used[y][x] = false;
                return;
            }
            if (node.isWordEnd) {
                findSet.add(key);
            }

            for (int i = 0; i < 8; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];
                if (ny < 0 || ny >= 4 || nx < 0 || nx >= 4 || used[ny][nx]) continue;
                node.search(ny, nx, key);
            }
            used[y][x] = false;
        }
    }
}
